package com.bridgelabz.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.beans.UserDetails;
import com.bridgelabz.repositry.DaoImplementation;
//service impementation class
public class ServiceImplementation implements ServiceInterface 
{
	DaoImplementation crud = new DaoImplementation();
	UserDetails user = new UserDetails();
   //method for registration
	@Override
	public int doregister(HttpServletRequest req) 
	{
		String username = req.getParameter("username");
		String gender = req.getParameter("gender");
		String phon = req.getParameter("phoneno");
		long phoneno = Long.parseLong(phon);
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		user.setUsername(username);
		user.setGender(gender);
		user.setPhoneno(phoneno);
		user.setEmail(email);
		user.setPassword(password);
		return crud.doregister(user);
	}
	//method for login
	@Override	
	public boolean dologin(HttpServletRequest request,HttpServletResponse response)
	{
		String email = request.getParameter("email");
		System.out.println(email);
		String password = request.getParameter("password");
		user.setEmail(email);
		user.setPassword(password);
		return crud.dologin(user);		
	}
	/*
	 * public boolean dochekcregister(HttpServletRequest request) { String email =
	 * request.getParameter("email"); user.setEmail(email); return
	 * crud.dovalidateregistration(user); }
	 */
}
