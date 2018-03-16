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
	EmployeeAddrDao employeeAddrDao = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("AddAddressEmployeeController doGet �޼��� ����");
		int employeeNo = Integer.parseInt(request.getParameter("employeeNo"));
		System.out.println(employeeNo+"<--- �Ѱܹ��� employeeNo");
		
		employeeAddrDao = new EmployeeAddrDao();
		int count = employeeAddrDao.countEmployeeAddr(employeeNo);
		
		
		if(count >= 5) {
			System.out.println("��ϺҰ�");
			request.setAttribute("count", count);
			request.getRequestDispatcher("/getEmployeeList.jjdev").forward(request, response);
		}else {
			System.out.println("��ϰ���");
			request.setAttribute("employeeNo", employeeNo);
			request.getRequestDispatcher("/WEB-INF/views/addAddressEmployee.jsp").forward(request, response);	
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("AddAddressEmployeeController doPost �޼��� ����");
		int employeeNo = Integer.parseInt(request.getParameter("employeeNo"));
		String employeeAddr = request.getParameter("employeeAddr");
		System.out.println(employeeNo+"<--- �Ѱܹ��� employeeNo");
		System.out.println(employeeAddr+"<--- �Ѱܹ��� employeeAddr");
		EmployeeAddr employeeaddr = new EmployeeAddr();
		employeeaddr.setEmployeeNo(employeeNo);
		employeeaddr.setAddress(employeeAddr);
		
		employeeAddrDao = new EmployeeAddrDao();
		employeeAddrDao.insertEmployeeAddr(employeeaddr);
		
		response.sendRedirect(request.getContextPath() + "/getEmployeeList.jjdev");
		
	}
}
