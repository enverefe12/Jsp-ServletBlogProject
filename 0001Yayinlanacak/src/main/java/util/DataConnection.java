package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataConnection {
	
	public Connection getDataConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/blogsitesi?user=root&password=12345&useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false");
	       
            return conn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}


}
