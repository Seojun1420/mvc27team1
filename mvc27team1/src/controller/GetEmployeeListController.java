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
		System.out.println("GetEmployeeListController doGet 메서드 실행");
		// request...
		// EmployeeDao
		// request에 속성추가
		// forward
		EmployeeDao employeeDao = new EmployeeDao();
		ArrayList<Employee> list = employeeDao.selectEmployee();
		request.setAttribute("Employee", list);
		request.getRequestDispatcher("/WEB-INF/views/getEmployeeList.jsp").forward(request, response);
	}
}
