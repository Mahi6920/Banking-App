package com.bank.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bank.model.User;
import com.bank.service.AdminService;

@WebServlet("/createAccount")
public class AccountCreationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fullName = request.getParameter("name");
		String mail = request.getParameter("mail");
		String amountStr = request.getParameter("balance");
		double initailAmount = Double.parseDouble(amountStr);
		
		// set the values
		User user = new User();
		user.setName(fullName);
		user.setMail(mail);
		user.setAmount(initailAmount);
		
		AdminService adminService = new AdminService();
		
		long accounNumber = adminService.accountCreation(user);
		
		if (accounNumber > 100) {
			request.setAttribute("success", "Account Creation Done");
			request.setAttribute("accountNumber", "Account Number: " + accounNumber);
			
			request.getRequestDispatcher("createAccount.jsp")
			.forward(request, response);
		} else {
			request.setAttribute("error", "Account Creation Fail");
			
			request.getRequestDispatcher("createAccount.jsp")
			.forward(request, response);
		}
		
	}

}
