package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import driver.Driver;

public class EmployeeAddrDao {
	Connection connection = null;
	PreparedStatement statement = null;
	public void insertEmployeeAddr(EmployeeAddr employeeaddr) {
		/*
		 * insertEmployeeAddr �޼���� �ּҸ� �߰��ϴ� �޼���
		 * void Ÿ���̹Ƿ� return�� ����, Employee Ŭ������ ���õ� ���� �Ű����������� �޾ƿ´�.
		 */	
		try {
			connection = Driver.dirverDbcon();
			/* 
		     * db������ ���� Driver Ŭ������ dirverDbcon �޼��� ȣ���Ѵ� .
		     */
			
			String sql = "INSERT INTO employee_addr VALUES(?,?,?)";
			statement = connection.prepareStatement(sql);
			//connection ��ü ���� ������ �Ҵ�� �������� ã�ư� prepareStatement�޼��带�����ϰ� �غ�� �������� �Է��Ѵ�.	

			statement.setInt(1, employeeaddr.getEmployeeAddrNo());
			statement.setInt(2, employeeaddr.getEmployeeNo());
			statement.setString(3, employeeaddr.getAddress());
			/*
		     * employeeaddr ��ü���������� �Ҵ�� �������� ã�ư� getEmployAddrNo, getEmployNo, getAddress �޼��带 ȣ����
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
