package com.bankingapp.repository;

import com.bankingapp.models.Customer;

public interface CustomerDAO {

	public Customer login(String email, String password);
	public boolean validateEmail(String email);
	public boolean verifyPassword(String email, String password);
	public int createCustomer(Customer customer);
	public Customer viewCustomer(int id);
	public int updateCustomer(Customer customer);
	public int deleteCustomer(int id);
}
