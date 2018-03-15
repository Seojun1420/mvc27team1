package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.EmployeeDao;

@WebServlet("/modifyEmployee.jjdev")
public class modifyEmployeeController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("modifyEmployeeController doGet 메서드 실행");
		int employeeNo = Integer.parseInt(request.getParameter("employeeNo"));
		System.out.println(employeeNo+"<--- 넘겨받은 employeeNo");
		EmployeeDao employeedao = new EmployeeDao();
		Employee employee = employeedao.employeeSelectForUpdate(employeeNo);
		request.setAttribute("employee", employee);
		request.getRequestDispatcher("/WEB-INF/views/modifyEmployeeForm.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("modifyEmployeeController doPost 메서드 실행");
		Employee employee = new Employee();
		int modifyEmployeeNo = Integer.parseInt(request.getParameter("modifyEmployeeNo"));
		String modifyEmployeeId = request.getParameter("modifyEmployeeId");
		String modifyEmployeePw = request.getParameter("modifyEmployeePw");
		System.out.println(modifyEmployeeNo+"<--- 넘겨받은 modifyEmployeeNo");
		System.out.println(modifyEmployeeId+"<--- 넘겨받은 modifyEmployeeId");
		System.out.println(modifyEmployeePw+"<--- 넘겨받은 modifyEmployeePw");
		
		employee.setEmployee_no(modifyEmployeeNo);
		employee.setEmployee_id(modifyEmployeeId);
		employee.setEmployee_pw(modifyEmployeePw);
		
		EmployeeDao employeedao = new EmployeeDao();
		employeedao.updateEmployee(employee);
		
		response.sendRedirect(request.getContextPath() + "/getEmployeeList.jjdev");
	}
}
