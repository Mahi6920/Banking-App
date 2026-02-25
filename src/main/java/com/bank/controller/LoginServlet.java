package com.bank.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.bank.model.Admin;
import com.bank.service.AdminService;
import com.bank.util.DBConnection;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	// Objects creation
	private DBConnection con = new DBConnection();
	private AdminService adminService = new AdminService();
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		
		Admin adminLogin = new Admin(mail, password);
		
		if (adminService.login(adminLogin)) {
			System.out.println("Login Done");
			
			request.setAttribute("mail", mail);
			request.setAttribute("password", password);
			
			response.sendRedirect("adminDashboard.jsp");
			
		} else {
			System.out.println("Login fail");
			
			response.sendRedirect("login.jsp");
		}
		
	}

}
