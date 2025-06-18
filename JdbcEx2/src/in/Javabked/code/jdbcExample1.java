package in.scalive.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcExample1 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			 conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","System","abc");
			System.out.println("Connection done");
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("Select Emp_name,sal from Emp");
			while(rs.next()) {
				String ename =rs.getString(1);
				double sal =rs.getDouble(2);
				System.out.println("Name : "+ename+" , Salary : "+sal);
				
			}
			
			
		} catch(SQLException ex ) {
			System.out.println("Exception :"+ ex.getMessage());
			
		}
		finally {
			try {
				if(conn!=null) {
					conn.close();
					System.out.println("Successfully closed the connection");
				}
			}
			catch(SQLException ex) {
				System.out.println("Exeption in closing the connection"+ex.getMessage());
			}
		}
	}

}
