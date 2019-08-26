package com.bridgelabz.servletcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.service.ServiceImplementation;

public class RegisterationController extends HttpServlet {
	ServiceImplementation service = new ServiceImplementation();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// boolean dogo=service.dochekcregister(request);
		// if (dogo==true)

		int status = service.doregister(request);

		System.out.println("status" + status);
		if (status > 0) // verfication..for checking availability of data
		{
			response.sendRedirect("loginpage.jsp"); // sending to login view page
		} else {
			response.sendRedirect("error.jsp");
		}
	}

}