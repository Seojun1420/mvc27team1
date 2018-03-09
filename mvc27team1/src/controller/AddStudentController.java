package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentDao;

@WebServlet("/addStudent.jjdev")
public class AddStudentController extends HttpServlet {
	// student �Է��� ��û
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/addStudent.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.request.ó�� 
		String StudentId = request.getParameter("StudentId");
		String StudentPw = request.getParameter("StudentPw");
		Student student = new Student();
		// guest setter ȣ��
		StudentDao stundetn = new StudentDao();
		//2.��(DAO) ȣ��
		//3.redirect(�ٸ� controllerȣ��)
		response.sendRedirect("/getStudentList.jjdev");
	}

}
