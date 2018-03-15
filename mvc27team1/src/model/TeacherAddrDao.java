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
			connection=Driver.dirverDbcon();//db연결
			statement=connection.prepareStatement(sql);//sql문 실행준비
			statement.setInt(1, teacherAddr.getTeacherNo());//sql 문 셋팅
			statement.setString(2,teacherAddr.getAddress());
			statement.executeUpdate();//sql실행
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

}
