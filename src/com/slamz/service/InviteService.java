package com.slamz.service;

import java.util.List;

import com.slamz.dao.InviteDao;
import com.slamz.model.Invite;
import com.slamz.model.User;

public class InviteService {
	
	private static InviteDao dao;
	
	static {
		dao = new InviteDao();
		dao.getConnection();
	}
	
	public static List<Invite> getInvitesForUser(User user) {
		return dao.selectByToUser(user);
	}


}
