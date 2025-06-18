package in.scalive.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcExample1 {
	public static void main(String[] args) {
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","System","abc");
			System.out.println("Connection done");
			
		} catch(SQLException ex ) {
			System.out.println("Exception :"+ ex.getMessage());
			
		}

}
}
