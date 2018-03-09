package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherDao {
	Connection connection=null;
	PreparedStatement statement=null;
	ResultSet resultSet =null;
	
	public void insertTeacher(Teacher teacher){
		String sql="INSERT INTO teacher VALUES(teacher_no,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver ="jdbc:mysql://localhost:3306/mvc?useUnicode=true&characterEncoding=euckr";
			String dbId ="root";
			String dbPw ="java0000";
			
			connection=DriverManager.getConnection(jdbcDriver,dbId,dbPw);
			
			statement=connection.prepareStatement(sql);
			statement.setString(1,teacher.getId());
			statement.setString(2,teacher.getPw());
			statement.executeUpdate();
			System.out.println(statement);
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList selectTeacher() {
		Teacher teacher =null;
		ArrayList<Teacher> arrayList = new ArrayList<Teacher>();
		String sql = "SELECT * FROM teacher";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver ="jdbc:mysql://localhost:3306/mvc?useUnicode=true&characterEncoding=euckr";
			String dbId ="root";
			String dbPw ="java0000";
			connection=DriverManager.getConnection(jdbcDriver,dbId,dbPw);
			statement=connection.prepareStatement(sql);
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
				teacher = new Teacher();
				teacher.setNum(resultSet.getInt("teacher_no"));
				teacher.setId(resultSet.getString("teacher_id"));
				teacher.setPw(resultSet.getString("teacher_pw"));
				arrayList.add(teacher);
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		return arrayList;
	}
	

}
