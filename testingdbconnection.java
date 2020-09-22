

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bankingapp.util.ConnectionClosers;
import com.bankingapp.util.DatabaseConnectionImpl;

public class testingdbconnection {
public static void main(String[] args) {
	testConnection();
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
