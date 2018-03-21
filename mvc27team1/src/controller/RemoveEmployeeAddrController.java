package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeAddrDao;

/**
 * Servlet implementation class RemoveEmployeeAddrController
 */
@WebServlet("/removeEmployeeAddr.jjdev")
public class RemoveEmployeeAddrController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" RemoveEmployeeAddrController doPro실행");
		String[] arr = request.getParameterValues("check");

		int[] intarr = new int[arr.length];

		if(arr != null) {
			for(int i=0; i <arr.length; i++) {
				intarr[i] = Integer.parseInt(arr[i]);
				System.out.println(intarr[i]+"<-- intarr");
			}
			
		EmployeeAddrDao employeeAddrDao = new EmployeeAddrDao();
		employeeAddrDao.removeEmployeeAddr(intarr);				
		response.sendRedirect(request.getContextPath() + "/getEmployeeList.jjdev");
		}
		
	}

}
