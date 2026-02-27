package com.bank.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bank.model.Admin;
import com.bank.service.AdminService;

@WebServlet("/adminRegister")
public class AdminRegistration extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// object creation 
	private AdminService adminService = new AdminService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");

		request.setAttribute("name", name);
		request.setAttribute("mail", mail);
		
		if (!password.equals(confirmPassword)) {
			System.out.println("Registration Fail");
			
			request.setAttribute("error", "Passwords do not match");

			request.getRequestDispatcher("adminRegister.jsp")
			.forward(request, response);
			return;   // VERY IMPORTANT
		}

		Admin admin = new Admin(name, mail, password);

		if (adminService.registration(admin) == 0) {
			System.out.println("Registration Done");

			request.setAttribute("success", "Registration Successful");
			request.getRequestDispatcher("adminRegister.jsp")
			.forward(request, response);
		} else if (adminService.registration(admin) == 1) {
			System.out.println("Registration Fail");

			request.setAttribute("error", "Enter valid credentials");
			request.getRequestDispatcher("adminRegister.jsp")
			.forward(request, response);
		} else if (adminService.registration(admin) == 2) {
			System.out.println("Registration Fail");

			request.setAttribute("error", "Enter E-mail");
			request.getRequestDispatcher("adminRegister.jsp")
			.forward(request, response);
		} else if (adminService.registration(admin) == 3) {
			System.out.println("Registration Fail");

			request.setAttribute("error", "Enter 6 Charector password");
			request.getRequestDispatcher("adminRegister.jsp")
			.forward(request, response);
		}
		

	}

}
