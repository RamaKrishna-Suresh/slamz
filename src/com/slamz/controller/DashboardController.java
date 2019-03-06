package com.slamz.controller;

import java.util.List;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slamz.model.Invite;
import com.slamz.model.User;
import com.slamz.service.InviteService;
import com.slamz.service.QuestionService;


@WebServlet("/dashboard")
public class DashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User activeUser = (User) request.getSession().getAttribute("activeUser");
		
		List<String> contents = QuestionService.getQuestonsForUser(activeUser);
		request.setAttribute("questionContents", contents);
		
		List<Invite> invites = InviteService.getInvitesForUser(activeUser);
		request.setAttribute("invites", invites);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/dashboard.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
