package com.bank.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bank.model.User;
import com.bank.service.AdminService;

@WebServlet("/deleteAccount")
public class AdminDeleteAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Object Creation
	private User user = new User();
	private AdminService adminService = new AdminService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String an = request.getParameter("accountNumber");

        if (an == null || an.isEmpty()) {
            request.setAttribute("error", "Enter account number");
            request.getRequestDispatcher("deleteAccount.jsp").forward(request, response);
            return;
            
        } else if (an.length() < 10) {
        	request.setAttribute("error", "Enter valid account number");
        }

        long accountNumber = Long.parseLong(an);
        user.setAccountNumber(accountNumber);

        if (adminService.deleteAccountNumber(user)) {

            request.setAttribute("success", "Account Deleted Successfully");
            request.getRequestDispatcher("deleteAccount.jsp").forward(request, response);

        } else {

            request.setAttribute("error", "Enter valid account number");
            request.getRequestDispatcher("deleteAccount.jsp").forward(request, response);
        }

	}

}
