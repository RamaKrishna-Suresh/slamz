package com.slamz.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.slamz.model.Invite;
import com.slamz.model.Question;
import com.slamz.model.User;

public class InviteDao extends JDBCBaseDao {
	
	public void insert(Invite invite) {
	    try {
	    	PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO invites (from_id,to_id) VALUES (?, ?)");
	    	preparedStatement.setInt(1, invite.getFromId());
	    	preparedStatement.setInt(2, invite.getToId());
	    	preparedStatement.executeUpdate();
	    	preparedStatement.close();
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }		
	}
	
	public List<Invite> selectByToUser(User user) {
		List<Invite> invites = new LinkedList<Invite>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"select * from invites "
					+ "inner join users as from_users on from_users.id = from_id "
					+ "where to_id=?");
			preparedStatement.setInt(1, user.getId());
			ResultSet resultSet = preparedStatement.executeQuery();
            Invite invite;  
			while(resultSet.next()){
				invite = new Invite();
		        invite.setFromId(resultSet.getInt("from_id"));	
		        
		        User fromUser = new User();
		        fromUser.setId(resultSet.getInt("from_users.id"));
		        fromUser.setName(resultSet.getString("from_users.name"));
		        fromUser.setEmail(resultSet.getString("from_users.email"));
		        fromUser.setPassword(resultSet.getString("from_users.password"));
		        
		        invite.setFromUser(fromUser);
		        
		        invite.setToId(resultSet.getInt("to_id"));					
	            invites.add(invite);
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return invites;
	}
	
	public  int getMaxVersion(User user) {
		ResultSet resultSet = null;
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"select max(version) as max_version from questions where user_id=? or version=0");
			preparedStatement.setInt(1,user.getId());
			resultSet = preparedStatement.executeQuery();
			if (!resultSet.next()) {
				return 0;
			}
			return Integer.parseInt(resultSet.getString("max_version"));

		} catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;	
	}
}

