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
		System.out.println("DeleteEmployeeController doGet 실행");
		int employeeNo = Integer.parseInt(request.getParameter("employeeNo"));
		System.out.println(employeeNo+"<---  employeeNo");
		EmployeeDao employeedao = new EmployeeDao();
		int result = employeedao.removeEmployee(employeeNo);
		request.setAttribute("result", result);
		System.out.println("3-1 에라");
		System.out.println(result+"result");		
		
		request.getRequestDispatcher("/getEmployeeList.jjdev").forward(request, response);
	}

}