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
			Class.forName("org.postgresql.Driver");
			Connection conn = 
					DriverManager.getConnection(getDatabaseURL(), getDatabaseUsername(), getDatabasePassword());
			if(conn != null) {
				System.out.println("conn ok");
			}
			else {
				System.out.println("no conn");
			}
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
