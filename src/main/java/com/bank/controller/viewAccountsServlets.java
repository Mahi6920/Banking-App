package com.bank.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.bank.model.Account;
import com.bank.service.AdminService;


@WebServlet("/viewAccounts")
public class viewAccountsServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Account> list = new AdminService().viewAccount();

		request.setAttribute("accounts", list);
		request.getRequestDispatcher("viewAccounts.jsp")
        .forward(request, response);
		
	}

}
