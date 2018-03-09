package driver;

//드라이버에 필요한 파일을  import 해준다
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Driver {
	public static Connection dirverDbcon() throws ClassNotFoundException, SQLException{
		
		Connection connection = null;
		
		//mysql 드라이버 로딩
		Class.forName("com.mysql.jdbc.Driver");
		
		//mysql 연결을 위해 ip, port, dbid, dbpw, db명 입력
		String jdbcDriver ="jdbc:mysql://localhost:3306/mvc?useUnicode=true&characterEncoding=utf-8";
		String dbUser = "root";
		String dbPass = "java0000";
	
		/* DriverManger 클래스의 getConnection 메서드 호출한다 .
	     * 이때  jdbcDriver, dbUser, dbpass를 매개변수 값으로 보낸다.
	     */
		connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
	
		return connection;
	}
	
	

}
