//mvc27team1 ������
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
	// employee �Է� ����û
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/addEmployee.jsp").forward(request, response);		
	}
	//employee �Է�
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String addEmployeeId = request.getParameter("addEmployeeId");
		String addEmployeePw = request.getParameter("addEmployeePw");
		System.out.println(addEmployeeId+"<-- addEmployeeId");
		System.out.println(addEmployeePw+"<-- addEmployeePw");
		// form���� �Է¹��� id�� pw�� request.getparameter�� ������ 
		Employee employee = new Employee();
		employee.setEmployee_id(addEmployeeId);
		employee.setEmployee_pw(addEmployeePw);
		// employee ��ü�� ������ employee ��ü ���ο� �����Ѵ�.
		
		this.employeeDao = new EmployeeDao();
		employeeDao.insertEmployee(employee);
		//ȸ�������� db�� �Է��ϱ� ���� EmployeeDao Ŭ������ insertEmployee �޼��带 ȣ�����ش�.
		
		response.sendRedirect(request.getContextPath() + "/getEmployeeList.jjdev");
		//����û�� �������Ƿ� listȭ������ response.sendRedirect ���ش�.
	}

}
