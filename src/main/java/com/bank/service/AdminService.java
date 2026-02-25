package com.bank.service;

import com.bank.dao.AdminDao;
import com.bank.model.Admin;

public class AdminService {
	
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
		
		
		return new AdminDao().login(admin);
	}
	
}
