package com.slamz.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.slamz.model.User;

public class UserDao extends JDBCBaseDao {

	public void insert(User user) {
	    try {
	    	PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (name, email, password) VALUES (?, ?, ?)");
	    	preparedStatement.setString(1,  user.getName());
	    	preparedStatement.setString(2, user.getEmail());
	    	preparedStatement.setString(3, user.getPassword());
	    	preparedStatement.executeUpdate();
	    	preparedStatement.close();
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }		
	}

	public List<User> select() {
		List<User> users = new LinkedList<User>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
                 
			User user = null;
			while(resultSet.next()){
				user = new User();
	            user.setId(Integer.parseInt(resultSet.getString("id")));
	            user.setName(resultSet.getString("name"));
	            user.setEmail(resultSet.getString("email"));
	            user.setPassword(resultSet.getString("password"));
	            users.add(user);
			}

			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public User selectByName(String name) {
		User user = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users where name=?");
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
                 
			while(resultSet.next()){
				user = new User();
	            user.setId(Integer.parseInt(resultSet.getString("id")));
	            user.setName(resultSet.getString("name"));
	            user.setEmail(resultSet.getString("email"));
	            user.setPassword(resultSet.getString("password"));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
