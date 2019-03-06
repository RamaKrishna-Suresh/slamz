package com.slamz.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		String requestURI = httpRequest.getRequestURI();
		
		boolean isLoggedIn = (session != null && session.getAttribute("activeUser") != null);
		boolean isPublicRequest = requestURI.contains("/public/");

		if (isPublicRequest || isLoggedIn) {
			chain.doFilter(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/public/index.jsp"); //NOTE: DO NOT SET CONTEXT IN URI HERE!
			dispatcher.forward(request, response);
		}
	}
}
