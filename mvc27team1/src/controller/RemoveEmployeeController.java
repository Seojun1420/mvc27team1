package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeDao;

@WebServlet("/removeEmployee.jjdev")
public class RemoveEmployeeController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("DeleteEmployeeController doGet ¸Þ¼­µå ½ÇÇà");
		int employeeNo = Integer.parseInt(request.getParameter("employeeNo"));
		System.out.println(employeeNo+"<--- ³Ñ°Ü¹ÞÀº employeeNo");
		EmployeeDao employeedao = new EmployeeDao();
		employeedao.deleteEmployee(employeeNo);
		
		response.sendRedirect(request.getContextPath() + "/getEmployeeList.jjdev");
	}

}