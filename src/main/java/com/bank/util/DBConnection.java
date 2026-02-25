package com.bank.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static final String URL = "jdbc:mysql://localhost:3306/banking_management";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "mahi";

	public static Connection getConnection() throws SQLException {


		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("My SQL Driver not found" + e);
		}
		


		return DriverManager.getConnection(URL, USERNAME, PASSWORD);

	}

}
