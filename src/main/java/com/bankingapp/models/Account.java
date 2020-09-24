package com.bankingapp.models;

import java.time.LocalDate;

public class Account {

	private int accountID;
	private String type;
	private double balance;
	private double availableCredit;
	private LocalDate dateCreated;
	private LocalDate dateLastModified;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int accountID, String type, double balance, double availableCredit, LocalDate dateCreated,
			LocalDate dateLastModified) {
		super();
		this.accountID = accountID;
		this.type = type;
		this.balance = balance;
		this.availableCredit = availableCredit;
		this.dateCreated = dateCreated;
		this.dateLastModified = dateLastModified;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAvailableCredit() {
		return availableCredit;
	}

	public void setAvailableCredit(double availableCredit) {
		this.availableCredit = availableCredit;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public LocalDate getDateLastModified() {
		return dateLastModified;
	}

	public void setDateLastModified(LocalDate dateLastModified) {
		this.dateLastModified = dateLastModified;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountID;
		long temp;
		temp = Double.doubleToLongBits(availableCredit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((dateLastModified == null) ? 0 : dateLastModified.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountID != other.accountID)
			return false;
		if (Double.doubleToLongBits(availableCredit) != Double.doubleToLongBits(other.availableCredit))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (dateLastModified == null) {
			if (other.dateLastModified != null)
				return false;
		} else if (!dateLastModified.equals(other.dateLastModified))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", type=" + type + ", balance=" + balance + ", availableCredit="
				+ availableCredit + ", dateCreated=" + dateCreated + ", dateLastModified=" + dateLastModified + "]";
	}
	
	
}
