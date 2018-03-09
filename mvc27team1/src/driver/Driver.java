package driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Driver {
	public static Connection dirverDbcon() throws ClassNotFoundException, SQLException{
		
		Connection connection = null;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String jdbcDriver ="jdbc:mysql://localhost:3306/mvc?useUnicode=true&characterEncoding=utf-8";
		String dbUser = "root";
		String dbPass = "java0000";
		
		connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
	
		return connection;
	}
	
	

}
