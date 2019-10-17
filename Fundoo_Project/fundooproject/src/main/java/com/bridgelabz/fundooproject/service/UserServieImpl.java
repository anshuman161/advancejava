package com.bridgelabz.fundooproject.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundooproject.exception.UserException;
import com.bridgelabz.fundooproject.model.UserDto;
import com.bridgelabz.fundooproject.model.UserInformation;
import com.bridgelabz.fundooproject.model.UserLogIn;
import com.bridgelabz.fundooproject.model.UserResetPasswordDto;
import com.bridgelabz.fundooproject.repository.UserRepositry;
import com.bridgelabz.fundooproject.utilmethods.Utility;

@Service
public class UserServieImpl implements UserService 
{
	@Autowired
	private UserRepositry user;

	@Autowired
	private BCryptPasswordEncoder bcrypt;

	@Autowired
	private Utility util;

	@Autowired
	private ModelMapper mapper;
   
	
	@Transactional
	@Override
	public void save(UserDto userDto) 
	{
		UserInformation userinformation = user.getUser(userDto.getEmail());
		if (userinformation == null) 
		{
			UserInformation information = mapper.map(userDto, UserInformation.class);
			String newPassword = bcrypt.encode(information.getPassword());
			information.setPassword(newPassword);
			information.setVerified(false);
			user.save(information);
			String tokens = util.generateTokens(information.getUserId());
			util.sendMail(userDto.getEmail(), "Email verifying", "http://localhost:8080/user/verify/" + tokens);
		}
		else 
		{
			 throw new UserException("User Already exist");
		}
	}
	@SuppressWarnings("unused")
	@Transactional
	@Override
	public void isVerify(String token) 
	{
		Long id = (long) util.parseToken(token);
		if (id != null) {
			user.saveVerfied(id);	
		} 
		else 
		{
			 throw new UserException("token verification failed");
		}
	}
	@Transactional
	@Override
	public String getLogIn(UserLogIn login) {
		UserInformation userInfo = user.getUser(login.getEmail());
		String token=null;
		if (userInfo.isVerified()==true) 
		{
			if (bcrypt.matches(login.getPassword(), userInfo.getPassword()) ) 
			{
			   	token=util.generateTokens(userInfo.getUserId());
			   	return token;
			} else 
			{
				 throw new UserException("Password is wrong!!!");
			}
		} else {
			util.sendMail(login.getEmail(), "Email verifying", "http://localhost:8080/user/verify/"+util.generateTokens(userInfo.getUserId()));
			 throw new UserException("User Not Exist");
		}
	}
	@Transactional
	@Override
	public boolean forgetPassword(String email) {
		UserInformation info = user.getUser(email);
		if (info != null) {
			util.sendMail(info.getEmail(), "Reset Password","http://localhost:4200/changePassword/" + util.generateTokens(info.getUserId()));
			return true;
		} else {
			throw new UserException("User Not Exist");
		}
	}
	@Transactional
	@Override
	public boolean resetPassword(UserResetPasswordDto password, String token)
	{         
		if (password.getPassword().equals(password.getConfirmPassword())) 
		{
			long userId = (long)util.parseToken(token);
			password.setConfirmPassword(bcrypt.encode(password.getConfirmPassword()));
			user.changePassword(password, userId);
			return true;
		} 
		else
		{
			throw new UserException("Password and Confirm password are not matched.");
		}
	}

	

}
