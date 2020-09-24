package com.bankingapp.models;

import java.util.HashSet;

public class CustomerAccount {

	private int customerID;
	private int accountID;
	private Customer customer;
	private HashSet<Account> accountList;
	
	public CustomerAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerAccount(int customerID, int accountID, Customer customer, HashSet<Account> accountList) {
		super();
		this.customerID = customerID;
		this.accountID = accountID;
		this.customer = customer;
		this.accountList = accountList;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public HashSet<Account> getAccountList() {
		return accountList;
	}
	public void setAccountList(HashSet<Account> accountList) {
		this.accountList = accountList;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountID;
		result = prime * result + ((accountList == null) ? 0 : accountList.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + customerID;
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
		CustomerAccount other = (CustomerAccount) obj;
		if (accountID != other.accountID)
			return false;
		if (accountList == null) {
			if (other.accountList != null)
				return false;
		} else if (!accountList.equals(other.accountList))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (customerID != other.customerID)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CustomerAccount [customerID=" + customerID + ", accountID=" + accountID + ", customer=" + customer
				+ ", accountList=" + accountList + "]";
	}
	
	
}
