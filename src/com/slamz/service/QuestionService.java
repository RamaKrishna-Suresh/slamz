package com.slamz.service;

import java.util.ArrayList;
import java.util.List;

import com.slamz.dao.QuestionDao;
import com.slamz.model.Question;
import com.slamz.model.User;

public class QuestionService {
	
	private static QuestionDao dao;
	
	static {
		dao = new QuestionDao();
		dao.getConnection();
	}
	
	public static List<String> getQuestonsForUser(User user) {
		List<Question> questions = dao.selectByUser(user);
		List<String> contents = new ArrayList<String>();
		questions.forEach(q->contents.add(q.getContent()));
		return contents;
	}
	
	public static void insertQuestionsForUser(User user,List<String> questionContents) {
		Question question = new Question();		
		int maxVersion = dao.getMaxVersion(user);
		maxVersion++;

		for(String content : questionContents) {
			question.setUserId(user.getId());
			question.setContent(content);
			question.setVersion(maxVersion);
			dao.insert(question);
		}

	}

}