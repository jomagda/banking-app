package com.bankingapp.util;

import java.sql.Connection;

public abstract class DatabaseConnection {

	private String driver = "org.postgresql.Driver";
	private String databaseURL = System.getenv("portfoliodburl");
	private String databaseUsername = System.getenv("portfoliodatabaseusername");
	private String databasePassword = System.getenv("portfoliodatabasepassword");
	
	public static DatabaseConnection getInstance() {
        return new DatabaseConnectionImpl();
    }
    
    public abstract Connection getConnection();

	public String getDriver() {
		return driver;
	}

	public String getDatabaseURL() {
		return databaseURL;
	}

	public String getDatabaseUsername() {
		return databaseUsername;
	}

	public String getDatabasePassword() {
		return databasePassword;
	}
    
    
}
