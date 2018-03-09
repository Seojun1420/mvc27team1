//mvc27team1 도정만
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
		 * selectEmployee 메서드는 db에 저장된 직원의 id와 pw를 보여 주는 메서드.
		 * Employee 클래스 타입의 ArrayList를 리턴한다.
		 */
		ArrayList<Employee> list = new ArrayList<Employee>();
		System.out.println("리스트 메서드 실행");
		
		try {
			Driver.dirverDbcon();
			/* 
		     * db연결을 위해 Driver 클래스의 dirverDbcon 메서드 호출한다 .
		     */
			String sql = "SELECT employee_no,employee_id,employee_pw FROM employee";
			statement = connection.prepareStatement(sql);			
			//connection 객체 참조 변수에 할당된 참조값을 찾아가 prepareStatement메서드를실행하고 준비된 쿼리문을 입력한다.	
			
			resultSet = statement.executeQuery();			
			/*
		     * statement 객체참조 변수에 할당된 참조값을 찾아가 executeQuery 메서드를 호출하면 준비된 쿼리 실행 후
		     *  실행결과를 resultSet 객체참조변수에 참조값을 할당한다.		    
		     */
			while(resultSet.next()) {
				/*  
		    	 * while문을 사용해서 ResultSet 객체내부의 next 메서드를 호출하면 실행결과가 있다면 true임으로 
		    	 * while문 안의 블럭이 실행된다. 그리고 다음 실행결과를 확인해서 true 이면 반복을 false 이면 while문을 종료 하게 된다.
		    	 */
				Employee employee = new Employee();
				employee.setEmployee_no(resultSet.getInt("employee_no"));
				employee.setEmployee_id(resultSet.getString("employee_id"));
				employee.setEmployee_pw(resultSet.getString("employee_pw"));
				list.add(employee);
			}
		
		}catch(ClassNotFoundException e) { //예외처리 Class.forName
			e.printStackTrace();			
		}catch(SQLException e) {// jdbc
			e.printStackTrace();
		}finally {
			if(resultSet != null) try {resultSet.close();} catch(SQLException e) {} //순서대로 가장 늦게 실행된 객체부터 닫아준다.
			if(statement != null) try{statement.close();} catch(SQLException e) {}
			if(connection != null) try{connection.close();} catch(SQLException e) {}
		}
		return list;
		
	}
	public void insertEmployee(Employee employee) {
		/*
		 * insertEmployee 메서드는 새로운 아나운서를 등록하는 메서드.
		 * void 타입이므로 return은 없고, Employee 클래스에 셋팅된 값을 매개변수값으로 받아온다.
		 */	
		try {
			Driver.dirverDbcon();
			/* 
		     * db연결을 위해 Driver 클래스의 dirverDbcon 메서드 호출한다 .
		     */
			
			String sql = "INSERT INTO employee VALUES(?,?,?)";
			statement = connection.prepareStatement(sql);
			//connection 객체 참조 변수에 할당된 참조값을 찾아가 prepareStatement메서드를실행하고 준비된 쿼리문을 입력한다.	

			statement.setInt(1, employee.getEmployee_no());
			statement.setString(2, employee.getEmployee_id());
			statement.setString(3, employee.getEmployee_pw());
			/*
		     * anaunseo 객체참조변수에 할당된 참조값을 찾아가 getAnaunseoId, getAnaunseoName, getAnaunseoAge 메서드를 호출후
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
}
