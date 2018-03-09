//mvc27team1 �ռ���
package model;

// �ʿ��� ������  import ���ش�
import java.sql.Connection;
import java.sql.DriverManager;
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
		System.out.println("===== StudentList =====");
		try {
			Driver db = new Driver();
			connection = db.dirverDbcon();
			System.out.println(connection+"db����");
			
			statement = connection.prepareStatement(sql);
			System.out.println("my-sql����");
			
			statement.setString(1, student.getId());	/* statement <-- ���̵� �ԷµȰɷ� Ȯ��*/
			System.out.println(statement + "<-- ���̵� �Է� Ȯ�� !");
			statement.setString(2, student.getPassword());	/*statement <-- �н����� �ԷµȰɷ� Ȯ��*/
			System.out.println(statement + "<-- ��� �Է� Ȯ�� !");
			statement.executeUpdate();
		
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	/*public ArrayList selectStudent() {
		
		ArrayList<Student> arrayList = new ArrayList<Student>();
		String sql = "SELECT * FROM student";
		return array;
	}*/
	
}
		
