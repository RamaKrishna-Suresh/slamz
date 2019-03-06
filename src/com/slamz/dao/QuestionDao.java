package com.slamz.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.slamz.model.Question;
import com.slamz.model.User;

public class QuestionDao extends JDBCBaseDao {
	
	public void insert(Question question) {
	    try {
	    	PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO questions (content, user_id, version) VALUES (?, ?, ?)");
	    	preparedStatement.setString(1,  question.getContent());
	    	preparedStatement.setInt(2, question.getUserId());
	    	preparedStatement.setInt(3, question.getVersion());
	    	preparedStatement.executeUpdate();
	    	preparedStatement.close();
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }		
	}
	
	public List<Question> selectByUser(User user) {
		List<Question> questions = new LinkedList<Question>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"SELECT * FROM questions "
					+ "where (user_id=? and version=(select max(version) from questions where user_id=?)) "
					+ "or version=0 "
					+ "order by version desc limit 3 ");
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setInt(2, user.getId());
			ResultSet resultSet = preparedStatement.executeQuery();
             Question question;    
			while(resultSet.next()){
				question = new Question();
				
				if(resultSet.getString("user_id") != null) {
		            question.setUserId(Integer.parseInt(resultSet.getString("user_id")));					
				}
				
	            question.setContent(resultSet.getString("content"));
	            question.setVersion(Integer.parseInt(resultSet.getString("version")));
	            questions.add(question);
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return questions;
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

