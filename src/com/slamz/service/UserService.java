package com.slamz.service;

import com.slamz.dao.UserDao;
import com.slamz.model.User;

public class UserService {
	
	private static UserDao dao;
	
	static {
		dao = new UserDao();
		dao.getConnection();
	}
	
	public static boolean authenticateAndSetRetrievedUser(User user) {
		User userRetrieved = dao.selectByName(user.getName());
		if (userRetrieved != null && userRetrieved.getPassword().equals(user.getPassword())) {
			user.setId(userRetrieved.getId());
			return true;
		}
		return false;
	}

}
