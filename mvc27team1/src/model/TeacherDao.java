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
		String sql="INSERT INTO teacher VALUES(teacher_no,?,?)";
		//DB ������ ���ְ� sql �� �غ� �� �ϼ� ���� ���ش�. try catch ������ ���ܰ� ������ Ȯ�����ش�.
		try {
			connection=Driver.dirverDbcon();
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
		//���ܰ� �߻��ϰų� ������ �Ϸ�Ǹ� statement ,connection �� �����ش�.
		finally {
			if(statement != null) try {statement.close();} catch(SQLException e) {}
			if(connection != null) try {connection.close();} catch(SQLException e) {}
		}
	}
	//ID,PW �� �Է��ѵ� ��� ��ư�� ������ LIST �� ���;��ϱ⶧���� SELECT ���� �޼��尡 �ʿ��ϴ�
	//����Ÿ���� ���� ����Ʈ���� (Teacher)�޾ƾ��� �ϹǷ� ArrayList<Teacher> �Ű������� ����
	public ArrayList<Teacher> selectTeacher() {
		ArrayList<Teacher> arrayList = new ArrayList<Teacher>();
		String sql = "SELECT * FROM teacher";
		try {
			//DB�� �����ϰ� SQL ������ �غ� �� ������ ���ش�.
			connection=Driver.dirverDbcon();
			statement=connection.prepareStatement(sql);
			resultSet=statement.executeQuery();
			//next() �޼���� �����ͺ��̽��� �ִ� �÷��� ���پ� �о�� Teacher ��ü�� �������ش�. �׸��� ArrayList�� add ���ش�.
			while(resultSet.next()) {
				Teacher	teacher = new Teacher();
				teacher.setNum(resultSet.getInt("teacher_no"));
				teacher.setId(resultSet.getString("teacher_id"));
				teacher.setPw(resultSet.getString("teacher_pw"));
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
}
