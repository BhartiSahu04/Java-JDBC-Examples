package in.scalive.code;
// WAP to display name and salary of every Emp the company using with the total salary and average salary of the company.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcExample3 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			 conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","System","abc");
			System.out.println("Connection done");
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("Select Emp_name,sal from Emp");
			double total =0;
			int count = 0;
			while(rs.next()) {
				String ename =rs.getString(1);
				double sal =rs.getDouble(2);
				total += sal;
				System.out.println("Name : "+ename+" , Salary : "+sal);
				++count;
				
			}
			System.out.println("Total Salary : "+ total);
			System.out.println("Average Salary : " + total/count);
			
			
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
