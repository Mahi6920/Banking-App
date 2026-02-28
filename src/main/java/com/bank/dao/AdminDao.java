package com.bank.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bank.model.Account;
import com.bank.model.Admin;
import com.bank.model.User;
import com.bank.util.DBConnection;


public class AdminDao {

	// login
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
	
	// registration
	public int registration(Admin admin) {
		
		int c = 0;
		
		String sql = "INSERT INTO admin(name, mail, password) VALUES (?, ?, ?);";
		
		try(Connection connection = DBConnection.getConnection()) {
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, admin.getName());
			preparedStatement.setString(2, admin.getMail());
			preparedStatement.setString(3, admin.getPassword());
			
			 if (preparedStatement.executeUpdate() > 0) {
				 return c;
			 }
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return 1;
		
	}
	
	// account creation 
	public long accountCreation(User user) {
		
		String sql = "INSERT INTO user(name, mail, amount) VALUES (?, ?, ?);";
		
		try(Connection connection = DBConnection.getConnection()) {
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getMail());
			preparedStatement.setDouble(3, user.getAmount());
			
			if (preparedStatement.executeUpdate() > 0) {				
				
				long accountNumber = 1003441000;
				
				// get the id and generate the account number 
				try {
			
					PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT * FROM user WHERE mail = ?;");
					preparedStatement2.setString(1, user.getMail());
					
					ResultSet resultSet = preparedStatement2.executeQuery();
					
					while(resultSet.next()) {
						accountNumber = accountNumber + resultSet.getInt(1);
					}
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				
				// account number update to that DB table				
				String accountSQL = "UPDATE user SET accountNumber = ? WHERE mail = ?;"; 
				
				PreparedStatement preparedStatement3 = connection.prepareStatement(accountSQL);
				preparedStatement3.setLong(1, accountNumber);
				preparedStatement3.setString(2, user.getMail());
				
				if (preparedStatement3.executeUpdate() > 0) {
					
					System.out.println("Account Number: " + accountNumber);
					
					return accountNumber;
				}
				
			} else {
				return -1;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return -1;
	}
	
	// view accounts
	public List<Account> viewAccount(){
		List<Account> list = new ArrayList<>();
		
		String sql = "SELECT * FROM user";
		
		try(Connection connection = DBConnection.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Account account = new Account(
						resultSet.getInt("id"), 
						resultSet.getString("name"), 
						resultSet.getString("mail"),
						resultSet.getDouble("amount"),
						resultSet.getLong("accountNumber")
						);
				list.add(account);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return list;
	}
}
