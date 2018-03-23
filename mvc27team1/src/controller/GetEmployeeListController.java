package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.parser.ParserBasicInformation;

import model.Employee;
import model.EmployeeDao;
import java.util.ArrayList;


@WebServlet("/getEmployeeList.jjdev")
public class GetEmployeeListController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//리스트화면 출력 요청이 들어오면
		request.setCharacterEncoding("UTF-8");
		System.out.println("GetEmployeeListController doGet 메서드 실행");
		System.out.println(request.getParameter("curruntPage")+"리스트페이지에서 넘어온curruntPage");
		int pagePerRow = 2; // 요청페이지에서 받을 수도 있다.
		
		int curruntPage = 1;
		if(request.getParameter("curruntPage") != null) {
			System.out.println("curruntPage != null 조건 ");
			curruntPage = Integer.parseInt(request.getParameter("curruntPage"));
		}
		
		int startRow = (curruntPage-1)*pagePerRow;
		System.out.println(startRow+"<--startRow");
		
		EmployeeDao employeeDao = new EmployeeDao();
		ArrayList<Employee> list = employeeDao.selectEmployee(startRow, pagePerRow);
		
		int totalRowCount = employeeDao.employeeRowCount();
		System.out.println(totalRowCount+"<--count 받아오기성공");
		int lastPage = totalRowCount / pagePerRow;
		if(totalRowCount % pagePerRow != 0) {
			lastPage++;
		}
		System.out.println(curruntPage+"controller curruntPage");
		//selectEmployee 메서드를 실행후 전체 회원 리스트를 ArrayList list로 받는다.
		request.setAttribute("list", list);
		request.setAttribute("curruntPage", curruntPage);
		request.setAttribute("lastPage", lastPage);
		request.getRequestDispatcher("/WEB-INF/views/getEmployeeList.jsp").forward(request, response);
		//reqest객체에 list를  담아 forward시킨다.
	}
}