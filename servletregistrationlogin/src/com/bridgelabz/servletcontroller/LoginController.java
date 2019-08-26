package com.bridgelabz.servletcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.service.ServiceImplementation;

public class LoginController extends HttpServlet {
	
	//private static final long serialVersionUID = 3622475172936598351L;
	ServiceImplementation service = new ServiceImplementation();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("login page controller");
		boolean demo = service.dologin(request, response);
		
		  if (demo == true) //verifing user is valid or not 
		{
		  System.out.println("inside if block"); 
		  HttpSession session =request.getSession(); //creating session object session.setAttribute("email",
		  session.setAttribute("email", request.getParameter("email")); //session set by email
		  session.setAttribute("password", request.getParameter("password"));
		  session.setMaxInactiveInterval(10); //giving time for max time display 
		  response.sendRedirect("homepage.jsp");
			/*
			 * String email=request.getParameter("email"); Cookie cookie=new Cookie("email",
			 * email); response.addCookie(cookie);
			 */		   
		 //// RequestDispatcher rd=request.getRequestDispatcher("homepage.jsp");
		 // rd.forward(request, response); 
		  }		
		else 
		{
			response.sendRedirect("error.jsp");
		}

	}

}
