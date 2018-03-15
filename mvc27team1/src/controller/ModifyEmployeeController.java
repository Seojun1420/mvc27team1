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
		//ȸ������ ��û�� �������� ����form�� �����ش�.
		request.setCharacterEncoding("UTF-8");
		System.out.println("modifyEmployeeController doGet �޼��� ����");
		int employeeNo = Integer.parseInt(request.getParameter("employeeNo"));
		System.out.println(employeeNo+"<--- �Ѱܹ��� employeeNo");
		//list���� ������ư�� ������ get������� employeeNo���� �Ѿ�´�.
		EmployeeDao employeedao = new EmployeeDao();
		Employee employee = employeedao.employeeSelectForUpdate(employeeNo);
		//employeeSelectForUpdate �޼��带 ���� �Ѱܹ��� employeeNo�� ������ return �޾� employee��ü�� ��´�.
		request.setAttribute("employee", employee);
		request.getRequestDispatcher("/WEB-INF/views/modifyEmployeeForm.jsp").forward(request, response);
		//�Ѹ��� ȸ�������� ���� employee 
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("modifyEmployeeController doPost �޼��� ����");
		Employee employee = new Employee();
		int modifyEmployeeNo = Integer.parseInt(request.getParameter("modifyEmployeeNo"));
		String modifyEmployeeId = request.getParameter("modifyEmployeeId");
		String modifyEmployeePw = request.getParameter("modifyEmployeePw");
		System.out.println(modifyEmployeeNo+"<--- �Ѱܹ��� modifyEmployeeNo");
		System.out.println(modifyEmployeeId+"<--- �Ѱܹ��� modifyEmployeeId");
		System.out.println(modifyEmployeePw+"<--- �Ѱܹ��� modifyEmployeePw");
		
		employee.setEmployee_no(modifyEmployeeNo);
		employee.setEmployee_id(modifyEmployeeId);
		employee.setEmployee_pw(modifyEmployeePw);
		
		EmployeeDao employeedao = new EmployeeDao();
		employeedao.updateEmployee(employee);
		
		response.sendRedirect(request.getContextPath() + "/getEmployeeList.jjdev");
	}
}
