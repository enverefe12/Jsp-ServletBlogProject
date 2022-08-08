package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataConnection {
	
	public Connection getDataConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        Connection conn=DriverManager.getConnection("jdbc:sqlserver://LAPTOP\\MICROSOFTSQLSERV:50291;DatabaseName=BlogSitesi;user=sa;password=12345;encrypt=true;trustServerCertificate=true;");
            return conn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}


}
