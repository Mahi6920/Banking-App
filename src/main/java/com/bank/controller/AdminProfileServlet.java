package com.bank.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bank.model.Account;
import com.bank.model.Admin;
import com.bank.service.AdminService;

@WebServlet("/admin")
public class AdminProfileServlet extends HttpServlet {
	AdminService adminService = new AdminService();

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        
        if (session == null || session.getAttribute("admin") == null) {
        	response.sendRedirect("adminLogin.jsp");
        	return;
        }
        
        Admin admin = (Admin) session.getAttribute("admin");
        admin.setMail(admin.getMail());
        
        
//        List<Admin> profile = new ArrayList<>();
        
        List<Admin> list = new AdminService().adminProfile(admin);
        
        request.setAttribute("admin", list);
		request.getRequestDispatcher("adminProfile.jsp")
        .forward(request, response);
        
        
//        if (profile != null) {
//        	request.setAttribute("adminDetails", admin);
//
//            request.getRequestDispatcher("adminProfile.jsp")
//                   .forward(request, response);
//        }
      
        
    }
}