package com.slamz.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slamz.dao.UserDao;
import com.slamz.model.User;

@WebServlet(urlPatterns = {"/public/signup"})
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = (String) request.getParameter("user");
		String password = (String) request.getParameter("password");
		String email = (String) request.getParameter("email");
		
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		user.setEmail(email);
		
		UserDao userDao = new UserDao();
		userDao.getConnection();
		userDao.insert(user);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/public/index.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
