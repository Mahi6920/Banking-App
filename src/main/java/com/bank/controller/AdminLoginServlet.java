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

@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	// Objects creation
	private AdminService adminService = new AdminService();
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		
		Admin admin = new Admin(mail, password);
		
		if (adminService.login(admin)) {
			System.out.println("Login Done");
			
			request.setAttribute("mail", mail);
			request.setAttribute("password", password);
			
			response.sendRedirect(request.getContextPath() + "/adminDashboard.jsp");
			
		} else {
			System.out.println("Login fail");
			
			request.setAttribute("error", "Wrong credentials entered");
		    request.getRequestDispatcher("adminLogin.jsp")
		           .forward(request, response);
		}
		
	}

}
