package com.bank.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bank.model.Admin;
import com.bank.util.DBConnection;

public class AdminDao {

	public boolean login(Admin admin) {
		
		try(Connection connection = DBConnection.getConnection()) {
			
			String sql = "SELECT * FROM admin WHERE mail = ? AND password = ?;";			
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, admin.getMail());
			preparedStatement.setString(2, admin.getPassword());
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			System.err.println("SQL Error" + e);			
		}
		
		return false;
	}
	
}
