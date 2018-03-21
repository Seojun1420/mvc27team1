package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import driver.Driver;

public class TeacherAddrDao {
	//addTeacherAddr 메서드 리턴타입 void 매개변수 TeacherAddr teacherAddr
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
	//countTeacherAddr 리턴타입 int 매개변수 int teacherNo
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
	//selectTeacherAddr메서드 리턴타입  ArrayList<TeacherAddr> 매개변수 int teacherNo
	public ArrayList<TeacherAddr> selectTeacherAddr(int teacherNo) {
		System.out.println("selectTeacherAddr 메서드 실행");
		Connection connection=null;
		PreparedStatement statement=null;
		ResultSet resultSet= null;
		TeacherAddr teacherAddr = null;
		ArrayList<TeacherAddr> arrayList = new ArrayList<TeacherAddr>();
		String sql = "SELECT * FROM teacher_addr WHERE teacher_no=?"; 
		
		try {
			connection=Driver.dirverDbcon();
			statement=connection.prepareStatement(sql);
			statement.setInt(1, teacherNo);
			resultSet=statement.executeQuery();
			System.out.println(resultSet);
			while(resultSet.next()) {
				teacherAddr = new TeacherAddr();
				teacherAddr.setTeacherAddrNo(resultSet.getInt("teacher_addr_no"));
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
	//removeTeacherAddr메서드 리턴타입 void 매개변수 int[] chechArr
	public void removeTeacherAddr(int[] checkArr) {
		System.out.println("removeTeacherAddr 메서드 실행");
		Connection connection=null;
		PreparedStatement statement=null;
		String sql = "DELETE FROM teacher_addr WHERE teacher_addr_no =?";
		int check =0;//매개변수로 남어온 값을 하나씩 저장하기위한 변수 check
		
		try {
			connection=Driver.dirverDbcon();
			for(int i=0;i<checkArr.length;i++) {//매개변수로 넘어온 배열을 for 을 활용해 값을꺼내고
				check =checkArr[i];				//배열의 첫번째 값을 check 담는다
				statement=connection.prepareStatement(sql);//쿼리 준비
				statement.setInt(1, check);//check 값을 셋팅해줘 sql 을 완성한다
				statement.executeUpdate();//완성된 쿼리문을 실행하고 for을통해 checkArr의 length까지 반복한다
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}