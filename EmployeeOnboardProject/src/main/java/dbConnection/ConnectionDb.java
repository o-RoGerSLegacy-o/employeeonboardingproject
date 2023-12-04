package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDb {
 
	public static Connection connectDb() {
	    try {
	        String url = "jdbc:mysql://localhost:3306/roger";
	        String userName = "root";
	        String password = "root";
	        Connection con = DriverManager.getConnection(url, userName, password);
	        System.out.println("Connected to the database.");
	        return con;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
}