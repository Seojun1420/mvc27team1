package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import driver.Driver;

public class TeacherAddrDao {
	Connection connection=null;
	PreparedStatement statement=null;
	ResultSet resultSet= null;
	public void addAdressTeacher(TeacherAddr teacherAddr) {
		System.out.println("addAdressTeacher �޼��� ����");
		String sql = "INSERT INTO teacher_addr VALUES(teacher_addr_no,?,?)";
		try {
			connection=Driver.dirverDbcon();//db����
			statement=connection.prepareStatement(sql);//sql�� �����غ�
			statement.setInt(1, teacherAddr.getTeacherNo());//sql �� ����
			statement.setString(2,teacherAddr.getAddress());
			statement.executeUpdate();//sql����
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public int countTeacherAddr(int teacherNo) {
		System.out.println("countTeacherAddr �޼��� ����");
		String sql = "SELECT COUNT(teacher_no) FROM teacher_addr WHERE teacher_no=?"; 
		int count=0;
		try {
			connection=Driver.dirverDbcon();
			statement=connection.prepareStatement(sql);
			statement.setInt(1, teacherNo);
			resultSet=statement.executeQuery();
			System.out.println(resultSet);
			if(resultSet.next()) {
				count=resultSet.getInt(1);
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

}
