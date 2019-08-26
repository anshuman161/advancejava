package com.bridgelabz.repositry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.beans.UserDetails;

public class DaoImplementation 
{

	static Connection connection = null;
    //creating get connection as a static for calling 
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ServletUserDatabase", "root", "root");
		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}
	/*
	 * public boolean dovalidateregistration(UserDetails user) { boolean demo=false;
	 * String email = user.getEmail(); connection = getConnection(); try {
	 * PreparedStatement state = connection
	 * .prepareStatement("select email from servletregistration where email=?");
	 * state.setString(1, user.getEmail()); ResultSet result = state.executeQuery();
	 * while (result.next()) { String dbemail = result.getString(1); if
	 * (dbemail.equals(email)) { System.out.println("You are already registered..");
	 * 
	 * } else { System.out.println("You can register!!"); demo=true;
	 * 
	 * } } state.close(); connection.close(); } catch (Exception e) { // TODO:
	 * handle exception } return demo; }
	 * 
	 */	
	//this method is using for registration , here passing pojo class
	public int doregister(UserDetails user) 
	{
		int status = 0;
		connection = getConnection();
		try {
			PreparedStatement pre = connection.prepareStatement("insert into servletregistration values(?,?,?,?,?)");
			pre.setString(1, user.getUsername());
			pre.setString(2, user.getGender());
			pre.setLong(3, user.getPhoneno());
			pre.setString(4, user.getEmail());
			pre.setString(5, user.getPassword());
			status = pre.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(status);
		return status;
	}

	//this method is using for login ,here passing pojo class
	public boolean dologin(UserDetails user) {
		boolean demo = false;
		String email = user.getEmail();
		String password = user.getPassword();
		String dbemail = null;
		String dbpassword = null;
		
		connection = getConnection();
		ResultSet result = null;
		try {
			PreparedStatement state = connection
					.prepareStatement("select email, password from servletregistration where email=? and password=?");
			state.setString(1, user.getEmail());
			state.setString(2, user.getPassword());
			result = state.executeQuery();
			while (result.next()) 
			{
				dbemail = result.getString(1);

				dbpassword = result.getString(2);

				if (dbemail.equals(email) && dbpassword.equals(password)) 
				{
					System.out.println("successfully log In.");
					demo = true;
				}
			}
			state.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return demo;

	}
	
	

}
