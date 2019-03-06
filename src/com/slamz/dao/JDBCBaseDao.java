package com.slamz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCBaseDao {
	
	Connection connection = null;
	 
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            if(connection == null) {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/slamz?useSSL=false&user=root&password=king6055");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
}
