package model;

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
	Employee employee = null;

	public Employee employeeSelectForUpdate(int employeeNo) {
		/*
		 * employeeSelectForUpdate 메서드는 회원수정버튼을 눌럿을때 정보를 form화면으로 뿌려주기위해 한명의회원정보를 select하기 위한 메서드
		 * Employee 클래스 타입의 employee를 리턴하고, 매개변수로 int형 타입의 employeeNo를 받는다.
		 */
		try {
			connection = Driver.dirverDbcon();
			/* 
		     * db연결을 위해 Driver 클래스의 dirverDbcon 메서드 호출한다 .
		     */
			String sql = "SELECT employee_no, employee_id, employee_pw FROM employee WHERE employee_no=?";
			
			statement = connection.prepareStatement(sql);
			//connection 객체 참조 변수에 할당된 참조값을 찾아가 prepareStatement메서드를실행하고 준비된 쿼리문을 입력한다.
			statement.setInt(1, employeeNo);
			//쿼리 완성
			
			resultSet = statement.executeQuery();
			System.out.println("<--04 쿼리실행");
			/*
		     * statement 객체참조 변수에 할당된 참조값을 찾아가 executeQuery 메서드를 호출하면 준비된 쿼리 실행 후
		     *  실행결과를 resultSet 객체참조변수에 참조값을 할당한다.		    
		     */
			
			if(resultSet.next()) {
				employee = new Employee();
				employee.setEmployee_no(resultSet.getInt("employee_no"));
				employee.setEmployee_id(resultSet.getString("employee_id"));
				employee.setEmployee_pw(resultSet.getString("employee_pw"));
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
		return employee;
	}
	public void deleteEmployee(int employeeNo) {
		/*
		 * deleteEmployee 메서드는 회원삭제를 하는 메서드
		 * 매개변수로 int형 타입의 employeeNo를 받아서 해당 employeeNo의 모든정보를 삭제한다
		 */
		try {
			connection = Driver.dirverDbcon();
			
			String sql = "DELETE FROM employee WHERE employee_no=?";
			statement = connection.prepareStatement(sql);
			//connection 객체 참조 변수에 할당된 참조값을 찾아가 prepareStatement메서드를실행하고 준비된 쿼리문을 입력한다.	

			statement.setInt(1, employeeNo);
			//쿼리 완성
			
			statement.executeUpdate();
			//DELETE 쿼리문 이므로 executeUpdate 메서드를 실행해 쿼리를 실행시켜준다.
			
		}catch(ClassNotFoundException e) { //예외처리 Class.forName
			e.printStackTrace();			
		}catch(SQLException e) {// jdbc
			e.printStackTrace();
		}finally {
			if(statement != null) try{statement.close();} catch(SQLException e) {} //순서대로 가장 늦게 실행된 객체부터 닫아준다.
			if(connection != null) try{connection.close();} catch(SQLException e) {}
		}
	}
	public void updateEmployee(Employee employee) {
		/*
		 * updateEmployee 메서드는 변경된 정보를 받아와 db에 적용 시키는 메서드
		 * 매개변수로 Employee클래스형 타입의 employee를 받아온다.
		 */
		try {
			connection = Driver.dirverDbcon();
			
			String sql = "UPDATE employee set employee_id=?, employee_pw=? WHERE employee_no=?";
			statement = connection.prepareStatement(sql);
			//connection 객체 참조 변수에 할당된 참조값을 찾아가 prepareStatement메서드를실행하고 준비된 쿼리문을 입력한다.	

			statement.setString(1, employee.getEmployee_id());
			statement.setString(2, employee.getEmployee_pw());
			statement.setInt(3, employee.getEmployee_no());
			//쿼리 완성
			
			statement.executeUpdate();
			//UPDATE 쿼리문 이므로 executeUpdate 메서드를 실행해 쿼리를 실행시켜준다.
			
		}catch(ClassNotFoundException e) { //예외처리 Class.forName
			e.printStackTrace();			
		}catch(SQLException e) {// jdbc
			e.printStackTrace();
		}finally {
			if(statement != null) try{statement.close();} catch(SQLException e) {} //순서대로 가장 늦게 실행된 객체부터 닫아준다.
			if(connection != null) try{connection.close();} catch(SQLException e) {}
		}
	}
	public ArrayList<Employee> selectEmployee() {
		/*
		 * selectEmployee 메서드는 db에 저장된 직원의 id와 pw를 보여 주는 메서드.
		 * Employee 클래스 타입의 ArrayList를 리턴한다.
		 */
		ArrayList<Employee> list = new ArrayList<Employee>();
		System.out.println("리스트 메서드 실행");
		
		try {
			connection = Driver.dirverDbcon();
			/* 
		     * db연결을 위해 Driver 클래스의 dirverDbcon 메서드 호출한다 .
		     */
			String sql = "SELECT employee_no,employee_id FROM employee";
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
		 * insertEmployee 메서드는 새로운 직원를 등록하는 메서드.
		 * void 타입이므로 return은 없고, Employee 클래스에 셋팅된 값을 매개변수값으로 받아온다.
		 */	
		try {
			connection = Driver.dirverDbcon();
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
		     * employee 객체참조변수에 할당된 참조값을 찾아가 getEmployee_no, getEmployee_id, getEmployee_pw 메서드를 호출후
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