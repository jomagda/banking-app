package com.bankingapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnectionImpl extends DatabaseConnection {

	@Override
	public Connection getConnection() {
		try {
			System.out.println(getDatabaseURL());
			Class.forName(getDriver());
			Connection conn = 
					DriverManager.getConnection(getDatabaseURL(), getDatabaseUsername(), getDatabasePassword());
			return conn;
		} catch(ClassNotFoundException ex) {
			Logger.getLogger(DatabaseConnectionImpl.class.getName()).log(Level.SEVERE, null, ex);
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

}
