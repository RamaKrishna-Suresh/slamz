package com.slamz.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.slamz.model.User;
import com.slamz.service.UserService;

@WebServlet(urlPatterns = {"/public/login"})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = (String) request.getParameter("name");
		String password = (String) request.getParameter("password");
		
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		
		HttpSession session = request.getSession();
		
		if (UserService.authenticateAndSetRetrievedUser(user)) {
			session.setAttribute("activeUser", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/dashboard");
			dispatcher.forward(request, response);	
		} else {
			request.setAttribute("errorMsg", "Invalid credentials");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/public/index.jsp");
			dispatcher.forward(request, response);		
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
