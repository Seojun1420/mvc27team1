package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentDao;

@WebServlet("/addStudent.jjdev")
public class AddStudentController extends HttpServlet {
	private StudentDao studentDao;
	
	// student 입력폼 요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/addStudent.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.request.처리 
		String StudentId = request.getParameter("StudentId");
		String StudentPw = request.getParameter("StudentPw");
		System.out.println(StudentId+","+StudentPw);
		// Student setter 호출
		Student student = new Student();
		student.setId(StudentId);
		student.setPassword(StudentPw);
		//2.모델(DAO) 호출
		this.studentDao = new StudentDao();
		studentDao.insertStudent(student);
		
		//3.redirect(다른 controller호출)
		response.sendRedirect(request.getContextPath()+"/getStudent.jjdev");
	}

}

