package com.bridgelabz.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ServiceInterface {
	public int doregister(HttpServletRequest req);
	public boolean dologin(HttpServletRequest request, HttpServletResponse response);
}
