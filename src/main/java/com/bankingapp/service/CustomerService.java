package com.bankingapp.service;

import com.bankingapp.repository.CustomerDAOImpl;

public class CustomerService {

	public boolean validateEmail(String email) {
		return new CustomerDAOImpl().validateEmail(email);
	}
}
