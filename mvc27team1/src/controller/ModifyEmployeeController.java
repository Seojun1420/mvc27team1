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
public class ModifyEmployeeController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원수정 요청이 들어왓을때 수정form을 보여준다.
		request.setCharacterEncoding("UTF-8");
		System.out.println("modifyEmployeeController doGet 메서드 실행");
		int employeeNo = Integer.parseInt(request.getParameter("employeeNo"));
		System.out.println(employeeNo+"<--- 넘겨받은 employeeNo");
		//list에서 수정버튼을 누르면 get방식으로 employeeNo값이 넘어온다.
		EmployeeDao employeedao = new EmployeeDao();
		Employee employee = employeedao.employeeSelectForUpdate(employeeNo);
		//employeeSelectForUpdate 메서드를 통해 넘겨받은 employeeNo의 정보를 return 받아 employee객체에 담는다.
		request.setAttribute("employee", employee);
		request.getRequestDispatcher("/WEB-INF/views/modifyEmployeeForm.jsp").forward(request, response);
		//한명의 회원정보를 담은 employee 
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
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
