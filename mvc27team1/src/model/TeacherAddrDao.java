package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import driver.Driver;

public class TeacherAddrDao {

	public void addTeacherAddr(TeacherAddr teacherAddr) {
		Connection connection=null;
		PreparedStatement statement=null;
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
		finally {
			if(statement !=null) try {statement.close();} catch(SQLException e) {}
			if(connection != null) try {connection.close();} catch(SQLException e) {}
		}
	}
	public int countTeacherAddr(int teacherNo) {
		Connection connection=null;
		PreparedStatement statement=null;
		ResultSet resultSet= null;
		System.out.println("countTeacherAddr 메서드 실행");
		String sql = "SELECT COUNT(*) FROM teacher_addr WHERE teacher_no=?"; 
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
		finally {
			if(resultSet != null) try {resultSet.close();} catch(SQLException e) {}
			if(statement != null) try {statement.close();} catch(SQLException e) {}
			if(connection != null) try {connection.close();} catch(SQLException e) {}
			}
		return count;
	}
	public ArrayList<TeacherAddr> selectTeacherAddr(int teacherNo) {
		Connection connection=null;
		PreparedStatement statement=null;
		ResultSet resultSet= null;
		TeacherAddr teacherAddr = new TeacherAddr();
		ArrayList<TeacherAddr> arrayList = new ArrayList<TeacherAddr>();
		System.out.println("selectTeacherAddr 메서드 실행");
		String sql = "SELECT address,teacher_no FROM teacher_addr WHERE teacher_no=?"; 
		
		try {
			connection=Driver.dirverDbcon();
			statement=connection.prepareStatement(sql);
			statement.setInt(1, teacherNo);
			resultSet=statement.executeQuery();
			System.out.println(resultSet);
			while(resultSet.next()) {
				teacherAddr.setTeacherNo(resultSet.getInt("teacher_no"));
				teacherAddr.setAddress(resultSet.getString("address"));
				arrayList.add(teacherAddr);
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(resultSet != null) try {resultSet.close();} catch(SQLException e) {}
			if(statement != null) try {statement.close();} catch(SQLException e) {}
			if(connection != null) try {connection.close();} catch(SQLException e) {}
			}
		return arrayList;
	}

}