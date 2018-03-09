package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Employee;
import model.EmployeeDao;
@WebServlet("/getEmployeeList.jjdev")
public class GetEmployeeListController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("리스트 두겟 메서드 실행");
		// request...
		// EmployeeDao
		// request에 속성추가
		// forward
		EmployeeDao employee = new EmployeeDao();
		employee.selectEmployee();
		request.getRequestDispatcher("/WEB-INF/views/getEmployeeList.jsp").forward(request, response);
	}
}
