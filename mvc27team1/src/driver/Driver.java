package driver;

//����̹��� �ʿ��� ������  import ���ش�
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Driver {
	public static Connection dirverDbcon() throws ClassNotFoundException, SQLException{
		
		Connection connection = null;
		
		//mysql ����̹� �ε�
		Class.forName("com.mysql.jdbc.Driver");
		
		//mysql ������ ���� ip, port, dbid, dbpw, db�� �Է�
		String jdbcDriver ="jdbc:mysql://localhost:3306/mvc?useUnicode=true&characterEncoding=utf-8";
		String dbUser = "root";
		String dbPass = "java0000";
	
		/* DriverManger Ŭ������ getConnection �޼��� ȣ���Ѵ� .
	     * �̶�  jdbcDriver, dbUser, dbpass�� �Ű����� ������ ������.
	     */
		connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
	
		return connection;
	}
	
	

}
