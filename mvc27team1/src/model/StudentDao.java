//mvc27team1 왕서준
package model;

// 필요한 파일을  import 해준다
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import driver.Driver;
import model.Student;

public class StudentDao {
	
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	
	public void insertStudent(Student student) {
		String sql = "INSERT INTO student VALUES (student_No,?,?)";
		System.out.println("===== insert Student =====");
		try {
			Driver db = new Driver();
			connection = db.dirverDbcon();
			System.out.println(connection+"db연결");
			
			statement = connection.prepareStatement(sql);
			System.out.println("my-sql연결");
			
			statement.setString(1, student.getId());	/* statement <-- 아이디 입력된걸로 확인*/
			System.out.println(statement + "<-- 아이디 입력 확인 !");
			statement.setString(2, student.getPassword());	/*statement <-- 패스워드 입력된걸로 확인*/
			System.out.println(statement + "<-- 비번 입력 확인 !");
			statement.executeUpdate();
		
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList selectStudent() {
		ArrayList<Student> arrayList = new ArrayList<Student>();
		String sql = "SELECT * FROM student";
		System.out.println("===== StudentList =====");
		try {
			Driver db = new Driver();
			connection = db.dirverDbcon();
			System.out.println(connection+"db연결");
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Student student = new Student();
				student.setNumber(resultSet.getInt("student_no"));
				student.setId(resultSet.getString("student_id"));
				student.setPassword(resultSet.getString("student_pw"));
				arrayList.add(student);
			}
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return arrayList;
	}
	
}
		
