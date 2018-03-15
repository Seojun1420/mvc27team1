package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import driver.Driver;

public class TeacherDao {
	Connection connection=null;
	PreparedStatement statement=null;
	ResultSet resultSet =null;
	//DB�� ID ,PW �� ������ �����ϴ� �޼��� ����Ÿ�� ���� , �Ű������� Teacher Ŭ���� �� �޴´�.
	public void insertTeacher(Teacher teacher){
		System.out.println("insertTeacher ����");
		String sql="INSERT INTO teacher VALUES(teacher_no,?,?)";
		//DB ������ ���ְ� sql �� �غ� �� �ϼ� ���� ���ش�. try catch ������ ���ܰ� ������ Ȯ�����ش�.
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
		//���ܰ� �߻��ϰų� ������ �Ϸ�Ǹ� statement ,connection �� �����ش�.
		finally {
			if(statement != null) try {statement.close();} catch(SQLException e) {}
			if(connection != null) try {connection.close();} catch(SQLException e) {}
		}
	}
	//ID,PW �� �Է��ѵ� ��� ��ư�� ������ LIST �� ���;��ϱ⶧���� SELECT ���� �޼��尡 �ʿ��ϴ�
	//����Ÿ���� ���� ����Ʈ���� (Teacher)�޾ƾ��� �ϹǷ� ArrayList<Teacher> �Ű������� ����
	public ArrayList<Teacher> selectTeacher() {
		System.out.println("selectTeacher ����");
		ArrayList<Teacher> arrayList = new ArrayList<Teacher>();
		String sql = "SELECT teacher_no,teacher_id FROM teacher";
		try {
			//DB�� �����ϰ� SQL ������ �غ� �� ������ ���ش�.
			connection=Driver.dirverDbcon();
			statement=connection.prepareStatement(sql);
			resultSet=statement.executeQuery();
			//next() �޼���� �����ͺ��̽��� �ִ� �÷��� ���پ� �о�� Teacher ��ü�� �������ش�. �׸��� ArrayList�� add ���ش�.
			while(resultSet.next()) {
				Teacher	teacher = new Teacher();
				teacher.setTeacher_no(resultSet.getInt("teacher_no"));
				teacher.setTeacher_id(resultSet.getString("teacher_id"));
				arrayList.add(teacher);
			}
			//try catch ������ ���ܹ߻��� ó�����ش�.
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		//���ܰ� �߻��ϰų�  finally �� if ���� �ִ� ������ ���̵Ǹ� try���� close()�޼��带 ������ �����ش�. 
		finally {
			if(resultSet != null) try {resultSet.close();} catch(SQLException e) {}
			if(statement != null) try {statement.close();} catch(SQLException e) {}
			if(connection != null) try {connection.close();} catch(SQLException e) {}
			}
		//arrayList �� �����Ѵ�.
		return arrayList;
	}
	public Teacher TeacherSelectForUpdate(int teacherNo) {
		System.out.println("TeacherSelectForUpdate ����");
			Teacher teacher = new Teacher();
			String sql ="SELECT * FROM teacher WHERE teacher_no=?";
			try {
				connection=Driver.dirverDbcon();//db ������ �Ѵ�
				statement=connection.prepareStatement(sql);//sql ������ �����غ� ���ش�.
				statement.setInt(1,teacherNo);//sql ���� �ϼ����ش�.
				resultSet=statement.executeQuery();//sql�� �����ϰ� �� ����� resultSet�� �����Ѵ�.
				
				while(resultSet.next()) {//resultSet�� next()�޼��带 ����� db�÷��� ������ �о� teacher�� set�޼��忡 �����Ѵ�.
					teacher.setTeacher_no(resultSet.getInt("teacher_no"));
					teacher.setTeacher_id(resultSet.getString("teacher_id"));
					teacher.setTeacher_pw(resultSet.getString("teacher_pw"));
				}
				
			}catch(ClassNotFoundException e) {//���ܰ� �߻���� catch�Ѵ�.
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			finally {//������ ������ finally�� if ���̽���� ������ ������ close ���ش�.
				if(resultSet !=null) try {resultSet.close();} catch(SQLException e) {}
				if(statement !=null) try {statement.close();} catch(SQLException e) {}
				if(connection != null) try {connection.close();} catch(SQLException e) {}
			}
		return teacher;//teacher �� ����
	}
	public void updateTeacher(Teacher teacher) {
		System.out.println("updateTeacher ����");
		String sql = "UPDATE teacher SET teacher_id=?,teacher_pw=?  WHERE teacher_no=?";
		try{
			connection=Driver.dirverDbcon();//db ������ �Ѵ�
			statement=connection.prepareStatement(sql);//sql ������ �����غ� ���ش�.
			statement.setString(1, teacher.getTeacher_id());//sql ���� �ϼ����ش�.
			statement.setString(2, teacher.getTeacher_pw());
			statement.setInt(3, teacher.getTeacher_no());
			statement.executeUpdate();//sql�� �����Ѵ�.
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
	public void deleteTeacher(int TeacherNo) {
		System.out.println("deleteTeacher ����");
		String sql = "DELETE FROM teacher WHERE teacher_no=?";
		try {
			connection=Driver.dirverDbcon();
			statement=connection.prepareStatement(sql);
			statement.setInt(1, TeacherNo);
			statement.executeUpdate();	
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
}
