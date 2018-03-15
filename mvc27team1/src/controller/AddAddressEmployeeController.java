package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeAddr;
import model.EmployeeAddrDao;


@WebServlet("/addAddressEmployee.jjdev")
public class AddAddressEmployeeController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddAddressEmployeeController doGet 메서드 실행");
		int employeeNo = Integer.parseInt(request.getParameter("employeeNo"));
		System.out.println(employeeNo+"<--- 넘겨받은 employeeNo");
		
		request.setAttribute("employeeNo", employeeNo);
		request.getRequestDispatcher("/WEB-INF/views/addAddressEmployee.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddAddressEmployeeController doGet 메서드 실행");
		int employeeNo = Integer.parseInt(request.getParameter("employeeNo"));
		System.out.println(employeeNo+"<--- 넘겨받은 employeeNo");
		
		EmployeeAddrDao employeeAddrDao = new EmployeeAddrDao();
		EmployeeAddr employeeaddr = new EmployeeAddr();
		employeeAddrDao.insertEmployeeAddr(employeeaddr);
		
		response.sendRedirect("/WEB-INF/views/getEmployeeList.jjdev");
		
	}
}
