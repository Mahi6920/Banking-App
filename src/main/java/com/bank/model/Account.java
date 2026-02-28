package com.bank.model;

public class Account {

    private long id;
    private String name;
    private String mail;
    private double balance;
    private long account_number;

    // constructor
    public Account(long id, String name, String mail, double balance, long account_number) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.balance = balance;
        this.account_number = account_number;
    }

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getMail() {
		return mail;
	}

	public double getBalance() {
		return balance;
	}
	
	public long getAccountNumber() {
		return account_number;
	}

}
