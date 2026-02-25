package com.bank.service;

import com.bank.dao.AdminDao;
import com.bank.model.Admin;

public class AdminService {
	
	// object creation
	AdminDao adminDao = new AdminDao();
	
	// login
	public boolean login(Admin admin) {
		
		if (admin == null) {
			System.err.println("Enter Details");
			return false;
		} else if (admin.getMail() == null) {
			System.err.println("Enter E-mail");
			return false;
		} else if (admin.getPassword().length() < 6) {
			System.out.println("Enter Valid Password");
			return false;
		}
		
		
		return adminDao.login(admin);
	}
	
	// registration
	public int registration(Admin admin) {
		int c = 0;
		
		if (admin == null) {
			c = 1;
			return c;
		} else if (admin.getMail() == null) {
			c = 2;
			return c;
		} else if (admin.getPassword().length() < 6) {
			c = 3;
			return c;
		}
		
		return adminDao.registration(admin);
	}
	
}
