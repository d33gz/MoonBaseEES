package revature.d33gz.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {
	public static Connection createConnection() {
		//Getting our Database Connection from the System Environment Variables
		
		//Fix LATER
		//String url = System.getenv(MOONBASE_DB_CONNECTION);
		
		//A Try Block for Connecting to our Database
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://database-revature-demo.c4n9s3foflfi.us-east-1.rds.amazonaws.com/MoonBaseEES?user=postgres&password=tr33fire");
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
