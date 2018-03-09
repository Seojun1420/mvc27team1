//mvc27team1 ������
package model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import driver.Driver;
public class EmployeeDao {
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	

	public ArrayList<Employee> selectEmployee() {
		/*
		 * selectEmployee �޼���� db�� ����� ������ id�� pw�� ���� �ִ� �޼���.
		 * Employee Ŭ���� Ÿ���� ArrayList�� �����Ѵ�.
		 */
		ArrayList<Employee> list = new ArrayList<Employee>();
		System.out.println("����Ʈ �޼��� ����");
		
		try {
			Driver.dirverDbcon();
			/* 
		     * db������ ���� Driver Ŭ������ dirverDbcon �޼��� ȣ���Ѵ� .
		     */
			String sql = "SELECT employee_no,employee_id,employee_pw FROM employee";
			statement = connection.prepareStatement(sql);			
			//connection ��ü ���� ������ �Ҵ�� �������� ã�ư� prepareStatement�޼��带�����ϰ� �غ�� �������� �Է��Ѵ�.	
			
			resultSet = statement.executeQuery();			
			/*
		     * statement ��ü���� ������ �Ҵ�� �������� ã�ư� executeQuery �޼��带 ȣ���ϸ� �غ�� ���� ���� ��
		     *  �������� resultSet ��ü���������� �������� �Ҵ��Ѵ�.		    
		     */
			while(resultSet.next()) {
				/*  
		    	 * while���� ����ؼ� ResultSet ��ü������ next �޼��带 ȣ���ϸ� �������� �ִٸ� true������ 
		    	 * while�� ���� ���� ����ȴ�. �׸��� ���� �������� Ȯ���ؼ� true �̸� �ݺ��� false �̸� while���� ���� �ϰ� �ȴ�.
		    	 */
				Employee employee = new Employee();
				employee.setEmployee_no(resultSet.getInt("employee_no"));
				employee.setEmployee_id(resultSet.getString("employee_id"));
				employee.setEmployee_pw(resultSet.getString("employee_pw"));
				list.add(employee);
			}
		
		}catch(ClassNotFoundException e) { //����ó�� Class.forName
			e.printStackTrace();			
		}catch(SQLException e) {// jdbc
			e.printStackTrace();
		}finally {
			if(resultSet != null) try {resultSet.close();} catch(SQLException e) {} //������� ���� �ʰ� ����� ��ü���� �ݾ��ش�.
			if(statement != null) try{statement.close();} catch(SQLException e) {}
			if(connection != null) try{connection.close();} catch(SQLException e) {}
		}
		return list;
		
	}
	public void insertEmployee(Employee employee) {
		/*
		 * insertEmployee �޼���� ���ο� �Ƴ���� ����ϴ� �޼���.
		 * void Ÿ���̹Ƿ� return�� ����, Employee Ŭ������ ���õ� ���� �Ű����������� �޾ƿ´�.
		 */	
		try {
			Driver.dirverDbcon();
			/* 
		     * db������ ���� Driver Ŭ������ dirverDbcon �޼��� ȣ���Ѵ� .
		     */
			
			String sql = "INSERT INTO employee VALUES(?,?,?)";
			statement = connection.prepareStatement(sql);
			//connection ��ü ���� ������ �Ҵ�� �������� ã�ư� prepareStatement�޼��带�����ϰ� �غ�� �������� �Է��Ѵ�.	

			statement.setInt(1, employee.getEmployee_no());
			statement.setString(2, employee.getEmployee_id());
			statement.setString(3, employee.getEmployee_pw());
			/*
		     * anaunseo ��ü���������� �Ҵ�� �������� ã�ư� getAnaunseoId, getAnaunseoName, getAnaunseoAge �޼��带 ȣ����
		     * return ���� ������ statment ��ü ���� ������ �Ҵ�� �������� ã�ư� PreparedStatement Ŭ������ setInt, setString �޼��带
		     * ȣ�� �� �Ű����������� �����Ѵ�.
		     * ���� �ϼ�!
		     */
			
			statement.executeUpdate();
			//INSERT ������ �̹Ƿ� executeUpdate �޼��带 ������ ������ ��������ش�.
			
		}catch(ClassNotFoundException e) { //����ó�� Class.forName
			e.printStackTrace();			
		}catch(SQLException e) {// jdbc
			e.printStackTrace();
		}finally {
			if(statement != null) try{statement.close();} catch(SQLException e) {} //������� ���� �ʰ� ����� ��ü���� �ݾ��ش�.
			if(connection != null) try{connection.close();} catch(SQLException e) {}
		}
	}
}
