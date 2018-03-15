package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import driver.Driver;

public class TeacherAddrDao {
	Connection connection=null;
	PreparedStatement statement=null;
	
	public void addAdressTeacher(TeacherAddr teacherAddr) {
		System.out.println("addAdressTeacher 메서드 실행");
		String sql = "INSERT INTO teacher_addr VALUES(teacher_addr_no,?,?)";
		try {
			connection=Driver.dirverDbcon();
			statement=connection.prepareStatement(sql);
			statement.setInt(1, teacherAddr.getTeacherNo());
			statement.setString(2,teacherAddr.getAddress());
			statement.executeUpdate();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

}
