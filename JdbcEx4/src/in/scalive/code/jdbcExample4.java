package in.scalive.code;
// WAP to insert the following record  empno = 107 , ename = Priya, sal = 60000, comm=1000; dept = 30

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcExample4 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			 conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","System","abc");
			System.out.println("Connection done");
			
			Statement st = conn.createStatement();
			String sql = "insert into Emp values(107 , 'Priya' , 60000 , 10000, 30)";
		    int count = st.executeUpdate(sql);
			System.out.println("Rec inserted"+ count);
			
			
			
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
