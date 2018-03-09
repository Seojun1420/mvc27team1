//mvc27team1 도정만
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.EmployeeDao;
import model.Employee;

@WebServlet("/addEmployee.jjdev")
public class AddEmployeeController extends HttpServlet {
	private EmployeeDao employeeDao;
	// guest 입력 폼요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/addEmployee.jsp").forward(request, response);
	}

	//guest 입력
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. request 처리
		//2. 모델 호출
		//3. 다른 Controller 호출 redirect
		String addEmployeeId = request.getParameter("addEmployeeId");
		String addEmployeePw = request.getParameter("addEmployeePw");
		System.out.println(addEmployeeId+"<-- addEmployeeId");
		System.out.println(addEmployeePw+"<-- addEmployeePw");
		//employee 호출
		Employee employee = new Employee();
		employee.setEmployee_id(addEmployeeId);
		employee.setEmployee_pw(addEmployeePw);
		
		this.employeeDao = new EmployeeDao();
		employeeDao.insertEmployee(employee);
		
		response.sendRedirect(request.getContextPath() + "/getEmployeeList.jjdev");
	}

}
