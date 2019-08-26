package com.bridgelabz.servletcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOut extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// with----session

		HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("loginpage.jsp");
		

		System.out.println("111111");

		/*
		 * Cookie cookie[]=request.getCookies();
		 * 
		 * for (Cookie cookie2 : cookie) { if (cookie2.getName().equals("email") ) {
		 * cookie2.setValue(null); cookie2.setMaxAge(0); response.addCookie(cookie2); }
		 * }
		 */
	}
}
