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
		//리스트화면 출력 요청이 들어오면
		request.setCharacterEncoding("UTF-8");
		System.out.println("GetEmployeeListController doGet 메서드 실행");
		EmployeeDao employeeDao = new EmployeeDao();
		ArrayList<Employee> list = employeeDao.selectEmployee();
		//selectEmployee 메서드를 실행후 전체 회원 리스트를 ArrayList list로 받는다.
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/getEmployeeList.jsp").forward(request, response);
		//reqest객체에 list를  담아 forward시킨다.
	}
}