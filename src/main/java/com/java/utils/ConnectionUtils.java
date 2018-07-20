package com.java.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

	private static String url="jdbc:mysql://localhost:3306/hrdb1";
	private static String user="root";
	private static String password="";
	
	public static Connection getConnection() throws SQLException
	{
		Connection connection=DriverManager.getConnection(url, user, password);
		connection.setAutoCommit(false);
		return connection;
	}
	
	public static void closeConnection(Connection connection) throws SQLException
	{
		if(connection!=null)
		
			connection.close();
		}
	

	public static Connection getConnection1() throws SQLException {
		// TODO Auto-generated method stub
		return getConnection();
	}
}