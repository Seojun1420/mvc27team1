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
public class AddEmployeeAddrController extends HttpServlet {
	EmployeeAddrDao employeeAddrDao = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("AddAddressEmployeeController doGet 메서드 실행");
		int employeeNo = Integer.parseInt(request.getParameter("employeeNo"));
		System.out.println(employeeNo+"<--- 넘겨받은 employeeNo");
		
		employeeAddrDao = new EmployeeAddrDao();
		int count = employeeAddrDao.countEmployeeAddr(employeeNo);
		
		
		if(count >= 5) {
			System.out.println("등록불가");
			request.setAttribute("employeeNo", employeeNo);
			request.getRequestDispatcher("/getEmployeeAddrList.jjdev").forward(request, response);
		}else {
			System.out.println("등록가능");
			request.setAttribute("employeeNo", employeeNo);
			request.getRequestDispatcher("/WEB-INF/views/addAddressEmployee.jsp").forward(request, response);	
		}				
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("AddAddressEmployeeController doPost 메서드 실행");
		int employeeNo = Integer.parseInt(request.getParameter("employeeNo"));
		String employeeAddr = request.getParameter("employeeAddr");
		System.out.println(employeeNo+"<--- 넘겨받은 employeeNo");
		System.out.println(employeeAddr+"<--- 넘겨받은 employeeAddr");
		EmployeeAddr employeeaddr = new EmployeeAddr();
		employeeaddr.setEmployeeNo(employeeNo);
		employeeaddr.setAddress(employeeAddr);
		
		employeeAddrDao = new EmployeeAddrDao();
		employeeAddrDao.addEmployeeAddr(employeeaddr);
		
		response.sendRedirect(request.getContextPath() + "/getEmployeeList.jjdev");		
	}
}