package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeAddr;
import model.EmployeeAddrDao;


@WebServlet("/getEmployeeAddrList.jjdev")
public class GetEmployeeAddrListController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int employeeNo = (int)request.getAttribute("employeeNo");
		System.out.println(employeeNo);
		
		EmployeeAddrDao employeeAddrDao = new EmployeeAddrDao();
		ArrayList<EmployeeAddr> list =employeeAddrDao.selectEmployeeAddr(employeeNo);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/getEmployeeAddrList.jsp").forward(request, response);
	}
}

