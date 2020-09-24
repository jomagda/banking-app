package com.bankingapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.mindrot.jbcrypt.BCrypt;

import com.bankingapp.models.Customer;
import com.bankingapp.util.ConnectionClosers;
import com.bankingapp.util.DatabaseConnectionImpl;

public class testingdbconnection {
	public static void main(String[] args) {
	//	testConnection();
		CustomerDAO dao = new CustomerDAOImpl();
		Customer c = new Customer(1, "Newnew", "Sheeran", "C", "HallFax", "West Yorkshire", "CA", 00000, "fake2@mail.com", "password", "1002003000", LocalDate.of(1991, 2, 17), LocalDate.now());
//		int id = dao.createCustomer(c);
//		System.out.println(dao.deleteCustomer(id));
//		System.out.println("ID: " + id);
		//System.out.println(dao.updateCustomer(c));
//		System.out.println(dao.viewCustomer(3));
		
		//System.out.println(dao.login("bogum@mail.com", "password"));
		System.out.println(dao.validateEmail("bogum2@mail.com"));
	}
		
	public static void testConnection() {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		int count = 0;
 
		try {
			conn = DatabaseConnectionImpl.getInstance().getConnection();
			ps = conn.prepareStatement("select * from account");

			rs = ps.executeQuery();
			
			while(rs.next())	{
				//System.out.println(rs.getString("firstname"));
				System.out.println(rs.getString("accounttype"));
			}
			

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(ps);
			ConnectionClosers.closeResultSet(rs);
		}
	}
}
