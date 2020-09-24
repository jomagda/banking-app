package com.bankingapp.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.mindrot.jbcrypt.BCrypt;

import com.bankingapp.models.Customer;
import com.bankingapp.util.ConnectionClosers;
import com.bankingapp.util.DatabaseConnectionImpl;

public class CustomerDAOImpl implements CustomerDAO{

	@Override
	public Customer login(String email, String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer c = null;
		final String query = "select * from customer where email = ?;";
		try {
			conn = DatabaseConnectionImpl.getInstance().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			while(rs.next()) {
				if(BCrypt.checkpw(password, rs.getString("userpassword"))) {
					c = new Customer();
					c.setCustomerID(rs.getInt("customerID"));
					c.setFirstName(rs.getString("firstname"));
					c.setLastName(rs.getString("lastname"));
					c.setMiddleInitial(rs.getString("middleinitial"));
					c.setStreetAddress(rs.getString("streetaddress"));
					c.setCity(rs.getString("city"));
					c.setState(rs.getString("state"));
					c.setZipcode(rs.getInt("zipcode"));
					c.setEmail(rs.getString("email"));
					c.setPhone(rs.getString("phone"));
					c.setBirthday(rs.getDate("birthday").toLocalDate());
					c.setDateCreated(rs.getDate("datejoined").toLocalDate());
				}
			}
			return c;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(rs);
			ConnectionClosers.closeStatement(ps);
		}
		return null;
	}

	@Override
	public boolean validateEmail(String email) {
		System.out.println("1");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean available = true;
		final String query = "select count(*) from customer where email = ?;";
		try {
			System.out.println("2");
			conn = DatabaseConnectionImpl.getInstance().getConnection();
			System.out.println("3");
			if(conn.equals(null)) {
				System.out.println("fuuuuck");
			}
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if(rs.next()) {
				if(rs.getInt("count") > 0) {
					available = false;
				}
			}
			return available;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			ConnectionClosers.closeResultSet(rs);
			ConnectionClosers.closeStatement(ps);
			ConnectionClosers.closeConnection(conn);
			
		}
		return available;
	}

	@Override
	public boolean verifyPassword(String email, String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean match = false;
		final String query = "select userpassword from customer where email = ?;";
		try {
			conn = DatabaseConnectionImpl.getInstance().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if(rs.next()) {
				if(BCrypt.checkpw(password, rs.getString("userpassword"))) {
					match = true;
				}
			}
			return match;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(rs);
			ConnectionClosers.closeStatement(ps);
		}
		return false;
	}
	
	@Override
	public int createCustomer(Customer customer) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int id = 0;
		final String query = "insert into customer values (default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = DatabaseConnectionImpl.getInstance().getConnection();
			ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getLastName());
			ps.setString(3, customer.getMiddleInitial());
			ps.setString(4, customer.getStreetAddress());
			ps.setString(5, customer.getCity());
			ps.setString(6, customer.getState());
			ps.setInt(7, customer.getZipcode());
			ps.setString(8, customer.getEmail());
			ps.setString(9, BCrypt.hashpw(customer.getUserPassword(), BCrypt.gensalt()));
			ps.setString(10, customer.getPhone());
			ps.setDate(11, Date.valueOf(customer.getBirthday()));
			ps.setDate(12, Date.valueOf(customer.getDateCreated()));
			
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				id = rs.getInt(1);
			}
			return id;
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(rs);
			ConnectionClosers.closeStatement(ps);
		}
		return -1;
	}

	@Override
	public Customer viewCustomer(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer c = null;
		final String query = "select * from customer where customerid = ?";
		try {
			conn = DatabaseConnectionImpl.getInstance().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				c = new Customer();
				c.setCustomerID(rs.getInt("customerID"));
				c.setFirstName(rs.getString("firstname"));
				c.setLastName(rs.getString("lastname"));
				c.setMiddleInitial(rs.getString("middleinitial"));
				c.setStreetAddress(rs.getString("streetaddress"));
				c.setCity(rs.getString("city"));
				c.setState(rs.getString("state"));
				c.setZipcode(rs.getInt("zipcode"));
				c.setEmail(rs.getString("email"));
				c.setPhone(rs.getString("phone"));
				c.setBirthday(rs.getDate("birthday").toLocalDate());
				c.setDateCreated(rs.getDate("datejoined").toLocalDate());
			}
			return c;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(rs);
			ConnectionClosers.closeStatement(ps);
		}
		return null;
	}

	@Override
	public int updateCustomer(Customer customer) {
		Connection conn = null;
		PreparedStatement ps = null;
		int update = 0;
		final String query = "update customer set firstname=?, lastname=?, middleinitial=?, "
				+ "streetaddress=?, city=?, state=?, zipcode=?, userpassword=?, phone=? where customerid=?;";
		try {
			conn = DatabaseConnectionImpl.getInstance().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getLastName());
			ps.setString(3, customer.getMiddleInitial());
			ps.setString(4, customer.getStreetAddress());
			ps.setString(5, customer.getCity());
			ps.setString(6, customer.getState());
			ps.setInt(7, customer.getZipcode());
			ps.setString(8, customer.getUserPassword());
			ps.setString(9, customer.getPhone());
			ps.setInt(10, customer.getCustomerID());
			
			update = ps.executeUpdate();
			return update;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(ps);
		}
		return -1;
	}

	@Override
	public int deleteCustomer(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		int delete = 0;
		final String query = "delete from customer where customerid = ?;";
		try {
			conn = DatabaseConnectionImpl.getInstance().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			delete = ps.executeUpdate();
			return delete;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(ps);
		}
		return -1;
	}

	

}
