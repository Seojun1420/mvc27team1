package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import driver.Driver;

public class EmployeeAddrDao {
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	
	public void removeEmployeeAddr(int[] intarr) {
		System.out.println("03_03 삭제처리");
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = Driver.dirverDbcon();
			/* 
		     * db연결을 위해 Driver 클래스의 dirverDbcon 메서드 호출한다 .
		     */
			String sql = "DELETE FROM employee_addr WHERE employee_addr_no=?";
			for(int i=0; i<intarr.length; i++) {
				
				statement = connection.prepareStatement(sql);
				statement.setInt(1, intarr[i]);
				statement.executeUpdate();
				System.out.println(intarr[i] + "<--- intarr[i]");
			}
			
		
		}catch(ClassNotFoundException e) { //예외처리 Class.forName
			e.printStackTrace();			
		}catch(SQLException e) {// jdbc
			e.printStackTrace();
		}finally {
			if(statement != null) try{statement.close();} catch(SQLException e) {} //순서대로 가장 늦게 실행된 객체부터 닫아준다.
			if(connection != null) try{connection.close();} catch(SQLException e) {}
		}
	}
	public void addEmployeeAddr(EmployeeAddr employeeaddr) {
		/*
		 * insertEmployeeAddr 메서드는 주소를 추가하는 메서드
		 * void 타입이므로 return은 없고, Employee 클래스에 셋팅된 값을 매개변수값으로 받아온다.
		 */	
		try {
			connection = Driver.dirverDbcon();
			/* 
		     * db연결을 위해 Driver 클래스의 dirverDbcon 메서드 호출한다 .
		     */
			
			String sql = "INSERT INTO employee_addr VALUES(?,?,?)";
			statement = connection.prepareStatement(sql);
			//connection 객체 참조 변수에 할당된 참조값을 찾아가 prepareStatement메서드를실행하고 준비된 쿼리문을 입력한다.	

			statement.setInt(1, employeeaddr.getEmployeeAddrNo());
			statement.setInt(2, employeeaddr.getEmployeeNo());
			statement.setString(3, employeeaddr.getAddress());
			/*
		     * employeeaddr 객체참조변수에 할당된 참조값을 찾아가 getEmployAddrNo, getEmployNo, getAddress 메서드를 호출후
		     * return 받은 값들을 statment 객체 참조 변수에 할당된 참조값을 찾아가 PreparedStatement 클래스의 setInt, setString 메서드를
		     * 호출 후 매개변수값으로 지정한다.
		     * 쿼리 완성!
		     */
			
			statement.executeUpdate();
			//INSERT 쿼리문 이므로 executeUpdate 메서드를 실행해 쿼리를 실행시켜준다.
			
		}catch(ClassNotFoundException e) { //예외처리 Class.forName
			e.printStackTrace();			
		}catch(SQLException e) {// jdbc
			e.printStackTrace();
		}finally {
			if(statement != null) try{statement.close();} catch(SQLException e) {} //순서대로 가장 늦게 실행된 객체부터 닫아준다.
			if(connection != null) try{connection.close();} catch(SQLException e) {}
		}
	}
	
	public int countEmployeeAddr(int employeeNo) {
		int count = 0;
		try {
			connection = Driver.dirverDbcon();
			/* 
		     * db연결을 위해 Driver 클래스의 dirverDbcon 메서드 호출한다 .
		     */
			
			String sql = "SELECT COUNT(employee_no) FROM employee_addr WHERE employee_no=?";
			statement = connection.prepareStatement(sql);

			statement.setInt(1, employeeNo);
			
			resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				count = resultSet.getInt(1);
			}
			
			
		}catch(ClassNotFoundException e) { //예외처리 Class.forName
			e.printStackTrace();			
		}catch(SQLException e) {// jdbc
			e.printStackTrace();
		}finally {
			if(resultSet != null) try{resultSet.close();} catch(SQLException e) {}
			if(statement != null) try{statement.close();} catch(SQLException e) {} //순서대로 가장 늦게 실행된 객체부터 닫아준다.
			if(connection != null) try{connection.close();} catch(SQLException e) {}
		}
		return count;
	}
	public ArrayList<EmployeeAddr>  selectEmployeeAddr(int employeeNo) {
		ArrayList<EmployeeAddr> list = new ArrayList<EmployeeAddr>();
		try {
			connection = Driver.dirverDbcon();
			/* 
		     * db연결을 위해 Driver 클래스의 dirverDbcon 메서드 호출한다 .
		     */
			
			String sql = "SELECT employee_addr_no, employee_no, address FROM employee_addr WHERE employee_no=?";			
			statement = connection.prepareStatement(sql);

			statement.setInt(1, employeeNo);
			
			resultSet = statement.executeQuery();
			EmployeeAddr employeeAddr = null;
			while(resultSet.next()) {
				employeeAddr = new EmployeeAddr();
				employeeAddr.setEmployeeAddrNo(resultSet.getInt("employee_addr_no"));
				employeeAddr.setEmployeeNo(resultSet.getInt("employee_no"));
				employeeAddr.setAddress(resultSet.getString("address"));
				list.add(employeeAddr);
			}
			
			
		}catch(ClassNotFoundException e) { //예외처리 Class.forName
			e.printStackTrace();			
		}catch(SQLException e) {// jdbc
			e.printStackTrace();
		}finally {
			if(resultSet != null) try{resultSet.close();} catch(SQLException e) {}
			if(statement != null) try{statement.close();} catch(SQLException e) {} //순서대로 가장 늦게 실행된 객체부터 닫아준다.
			if(connection != null) try{connection.close();} catch(SQLException e) {}
		}
		return list;
	}
}