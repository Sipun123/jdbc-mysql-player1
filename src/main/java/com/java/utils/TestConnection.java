package com.java.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection=ConnectionUtils.getConnection1();
		System.out.println(connection);
		ConnectionUtils.closeConnection(connection);
	}

}
