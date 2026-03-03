package com.bank.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.bank.model.Admin;
import com.bank.service.AdminService;

@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	// Objects creation
	private AdminService adminService = new AdminService();


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");

//		request.getSession().setAttribute("admin", mail);
			
//		Admin admin = new Admin(mail, password);
		
		Admin admin = new Admin();
		
		admin.setMail(mail);
		admin.setPassword(password);
		
				
		if (adminService.login(admin)) {
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);

//			response.sendRedirect("adminDashboard.jsp");
			
			response.sendRedirect("adminDashboard");
		} else {
			System.out.println("Login fail");

			request.setAttribute("error", "Wrong credentials entered");
			request.getRequestDispatcher("adminLogin.jsp")
			.forward(request, response);
		}


	}

}
