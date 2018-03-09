package model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.Connection;

public class EmployeeDao {
	Connection connection = null;
	PreparedStatement statement = null;
	public void insertEmployee(Employee employee) {
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/mvc";
			String dbId = "root";
			String dbPw = "java0000";
			String sql = "INSERT INTO employee VALUES(?,?,?)";
			connection = DriverManager.getConnection(jdbcDriver, dbId, dbPw);
			
			statement = connection.prepareStatement(sql);
			System.out.println(statement + "<--statement1");
			statement.setInt(1, employee.getEmployee_no());
			statement.setString(2, employee.getEmployee_id());
			statement.setString(3, employee.getEmployee_pw());
			System.out.println(statement + "<--statement2");
			
			statement.executeUpdate();
			System.out.println(statement);
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(statement != null) try{statement.close();} catch(SQLException e) {}
			if(connection != null) try{connection.close();} catch(SQLException e) {}
		}
	}
}
