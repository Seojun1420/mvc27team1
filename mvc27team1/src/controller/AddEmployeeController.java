//mvc27team1 도정만
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.EmployeeDao;
import model.Employee;

@WebServlet("/addEmployee.jjdev")
public class AddEmployeeController extends HttpServlet {
	private EmployeeDao employeeDao;
	// employee 입력 폼요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/addEmployee.jsp").forward(request, response);		
	}
	//employee 입력
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String addEmployeeId = request.getParameter("addEmployeeId");
		String addEmployeePw = request.getParameter("addEmployeePw");
		System.out.println(addEmployeeId+"<-- addEmployeeId");
		System.out.println(addEmployeePw+"<-- addEmployeePw");
		// form에서 입력받은 id와 pw를 request.getparameter로 받은후 
		Employee employee = new Employee();
		employee.setEmployee_id(addEmployeeId);
		employee.setEmployee_pw(addEmployeePw);
		// employee 객체를 생성후 employee 객체 내부에 셋팅한다.
		
		this.employeeDao = new EmployeeDao();
		employeeDao.insertEmployee(employee);
		//회원정보를 db에 입력하기 위해 EmployeeDao 클래스의 insertEmployee 메서드를 호출해준다.
		
		response.sendRedirect(request.getContextPath() + "/getEmployeeList.jjdev");
		//모든요청이 끝낫으므로 list화면으로 response.sendRedirect 해준다.
	}

}