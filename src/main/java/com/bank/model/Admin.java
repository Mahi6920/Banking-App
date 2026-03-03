package com.bank.model;

public class Admin {
	private int id;
	private String name;
	private String mail;
	private String password;
	
	public Admin() {
		
	}
	
	public Admin(String name, String mail, String password) {
		this.name = name;
		this.mail = mail;
		this.password = password;
	}
	
	public Admin(int id, String name, String mail) {
		this.id = id;
		this.name = name;
		this.mail = mail;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
