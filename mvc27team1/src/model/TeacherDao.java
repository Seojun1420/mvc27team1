package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import driver.Driver;

public class TeacherDao {
	//DB에 ID ,PW 의 정보를 저장하는 메서드 리턴타입 없음 , 매개변수로 Teacher 클래스 를 받는다.
	public void insertTeacher(Teacher teacher){
		Connection connection=null;
		PreparedStatement statement=null;
		System.out.println("insertTeacher 실행");
		String sql="INSERT INTO teacher VALUES(teacher_no,?,?)";
		//DB 연결을 해주고 sql 을 준비 및 완성 실행 해준다. try catch 문으로 예외가 있으면 확인해준다.
		try {
			connection=Driver.dirverDbcon();
			statement=connection.prepareStatement(sql);
			statement.setString(1,teacher.getTeacher_id());
			statement.setString(2,teacher.getTeacher_pw());
			statement.executeUpdate();
			System.out.println(statement);
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		//예외가 발생하거나 실행이 완료되면 statement ,connection 을 끝내준다.
		finally {
			if(statement != null) try {statement.close();} catch(SQLException e) {}
			if(connection != null) try {connection.close();} catch(SQLException e) {}
		}
	}
	public int teacherRowCount() {
		Connection connection=null;
		PreparedStatement statement=null;
		ResultSet resultSet =null;
		int count=0;
		String sql = "SELECT COUNT(*) AS count FROM teacher";
		try {
			connection=Driver.dirverDbcon();
			statement=connection.prepareStatement(sql);
			resultSet=statement.executeQuery();
			if(resultSet.next()) {
				count=resultSet.getInt("count");
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		//예외가 발생하거나  finally 의 if 문에 있는 조건이 참이되면 try에가 close()메서드를 실행해 끝내준다. 
		finally {
			if(resultSet != null) try {resultSet.close();} catch(SQLException e) {}
			if(statement != null) try {statement.close();} catch(SQLException e) {}
			if(connection != null) try {connection.close();} catch(SQLException e) {}
			}
		return count;
	}
	
	/*
	 * ID,PW 를 입력한뒤 등록 버튼을 눌르면 LIST 가 나와야하기때문에 SELECT 해줄 메서드가 필요하다
	 * 리턴타입은 여러 리스트들을 (Teacher)받아야하 하므로 ArrayList<Teacher> int 매개변수 startRow ->select 결과물의 시작행
	 * 
	 */
	public ArrayList<Teacher> selectTeacher(int currentPage,int pageRerRow) {
		Connection connection=null;
		PreparedStatement statement=null;
		ResultSet resultSet =null;
		System.out.println("selectTeacher 실행");
		ArrayList<Teacher> arrayList = new ArrayList<Teacher>();
		String sql = "SELECT teacher_no,teacher_id FROM teacher LIMIT ?,?";
		try {
			//DB를 연결하고 SQL 쿼리를 준비 및 실행을 해준다.
			connection=Driver.dirverDbcon();
			statement=connection.prepareStatement(sql);
			statement.setInt(1, currentPage);
			statement.setInt(2, pageRerRow);
			resultSet=statement.executeQuery();
			//next() 메서드로 데이터베이스에 있는 컬럼을 한줄씩 읽어와 Teacher 객체에 셋팅해준다. 그리고 ArrayList에 add 해준다.
			while(resultSet.next()) {
				Teacher	teacher = new Teacher();
				teacher.setTeacher_no(resultSet.getInt("teacher_no"));
				teacher.setTeacher_id(resultSet.getString("teacher_id"));
				arrayList.add(teacher);
			}
			//try catch 문으로 예외발생시 처리해준다.
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		//예외가 발생하거나  finally 의 if 문에 있는 조건이 참이되면 try에가 close()메서드를 실행해 끝내준다. 
		finally {
			if(resultSet != null) try {resultSet.close();} catch(SQLException e) {}
			if(statement != null) try {statement.close();} catch(SQLException e) {}
			if(connection != null) try {connection.close();} catch(SQLException e) {}
			}
		//arrayList 를 리턴한다.
		return arrayList;
	}
	public Teacher TeacherSelectForUpdate(int teacherNo) {
		Connection connection=null;
		PreparedStatement statement=null;
		ResultSet resultSet =null;
		System.out.println("TeacherSelectForUpdate 실행");
			Teacher teacher = new Teacher();
			String sql ="SELECT * FROM teacher WHERE teacher_no=?";
			try {
				connection=Driver.dirverDbcon();//db 연결을 한다
				statement=connection.prepareStatement(sql);//sql 쿼리문 실행준비를 해준다.
				statement.setInt(1,teacherNo);//sql 문을 완성해준다.
				resultSet=statement.executeQuery();//sql을 실행하고 그 결과를 resultSet에 저장한다.
				
				while(resultSet.next()) {//resultSet의 next()메서드를 사용해 db컬럼의 정보를 읽어 teacher의 set메서드에 셋팅한다.
					teacher.setTeacher_no(resultSet.getInt("teacher_no"));
					teacher.setTeacher_id(resultSet.getString("teacher_id"));
					teacher.setTeacher_pw(resultSet.getString("teacher_pw"));
				}
				
			}catch(ClassNotFoundException e) {//예외가 발생퇴면 catch한다.
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			finally {//실행이 끝나면 finally의 if 문이실행되 조건이 맞으면 close 해준다.
				if(resultSet !=null) try {resultSet.close();} catch(SQLException e) {}
				if(statement !=null) try {statement.close();} catch(SQLException e) {}
				if(connection != null) try {connection.close();} catch(SQLException e) {}
			}
		return teacher;//teacher 를 리턴
	}
	public void updateTeacher(Teacher teacher) {
		Connection connection=null;
		PreparedStatement statement=null;
		System.out.println("updateTeacher 실행");
		String sql = "UPDATE teacher SET teacher_id=?,teacher_pw=?  WHERE teacher_no=?";
		try{
			connection=Driver.dirverDbcon();//db 연결을 한다
			statement=connection.prepareStatement(sql);//sql 쿼리문 실행준비를 해준다.
			statement.setString(1, teacher.getTeacher_id());//sql 문을 완성해준다.
			statement.setString(2, teacher.getTeacher_pw());
			statement.setInt(3, teacher.getTeacher_no());
			statement.executeUpdate();//sql을 실행한다.
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
	public int deleteTeacher(int TeacherNo) {
		Connection connection=null;
		PreparedStatement statement=null;
		System.out.println("deleteTeacher 실행");
		String sql = "DELETE FROM teacher WHERE teacher_no=?";
		int result=0;
		try {
			connection=Driver.dirverDbcon();
			statement=connection.prepareStatement(sql);
			statement.setInt(1, TeacherNo);
			result=statement.executeUpdate();	
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("1");
			return result;
		}
		finally {
			System.out.println("2");
			if(statement !=null) try {statement.close();} catch(SQLException e) {}
			if(connection != null) try {connection.close();} catch(SQLException e) {}
			System.out.println("3");
		}
		System.out.println("4");
		return result;
	}
}