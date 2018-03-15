package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Employee;
import model.EmployeeDao;
import java.util.ArrayList;


@WebServlet("/getEmployeeList.jjdev")
public class GetEmployeeListController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����Ʈȭ�� ��� ��û�� ������
		request.setCharacterEncoding("UTF-8");
		System.out.println("GetEmployeeListController doGet �޼��� ����");
		EmployeeDao employeeDao = new EmployeeDao();
		ArrayList<Employee> list = employeeDao.selectEmployee();
		//selectEmployee �޼��带 ������ ��ü ȸ�� ����Ʈ�� ArrayList list�� �޴´�.
		request.setAttribute("Employee", list);
		request.getRequestDispatcher("/WEB-INF/views/getEmployeeList.jsp").forward(request, response);
		//reqest��ü�� list��  ��� forward��Ų��.
	}
}
