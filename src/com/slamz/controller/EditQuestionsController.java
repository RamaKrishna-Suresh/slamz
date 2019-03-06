package com.slamz.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slamz.model.User;
import com.slamz.service.QuestionService;

@WebServlet("/editQuestions")
public class EditQuestionsController extends HttpServlet {
	private static final long serialVersionUID = 1L;


    


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User activeUser = (User) request.getSession().getAttribute("activeUser");
		List<String> questionContents = new LinkedList<String>();
		questionContents.add((String) request.getParameter("question1"));
		questionContents.add((String) request.getParameter("question2"));
		questionContents.add((String) request.getParameter("question3"));
		QuestionService.insertQuestionsForUser(activeUser, questionContents);
				
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/dashboard");
		requestDispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
