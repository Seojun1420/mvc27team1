package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Student;

public class StudentDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "INSERT INTO student VALUES (?,?,?)";
	
	public void insertStudent(Student student) throws ClassNotFoundException, SQLException  {
		System.out.println("===== StudentList =====");
		Class.forName("com.mysql.jdbc.Driver");
		// db, ip, Id, pw ���� �κ�
		try {
			String jdbcDriver = "jdbc:mysql://localhost:3306/mvc?" +
					"useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			System.out.println(conn+"db����");
			
			/*System.out.println(pstmt + "<-- ���̵� �ԷµȰɷ� Ȯ��");*/
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, student.getStudent_No());
			pstmt.setString(2, student.getStudent_Id());
			pstmt.setString(3, student.getStudent_Pw());
			/*System.out.println(pstmt + "<-- �н����� �ԷµȰɷ� Ȯ��");*/
			
			pstmt.executeUpdate();
		}catch(ClassCastException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if (pstmt != null) try {pstmt.close(); } catch(SQLException e) {}			
			if (conn != null) try { conn.close(); } catch(SQLException e) {}
		}
	}
}
		
