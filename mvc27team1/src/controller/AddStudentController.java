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
		String Student_Id = request.getParameter("Student_Id");
		String Student_Pw = request.getParameter("Student_Pw");
		System.out.println(Student_Id+","+Student_Pw);
		Student student = new Student();
		// guest setter 호출
		this.studentDao = new StudentDao();
		try {
			studentDao.insertStudent(student);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2.모델(DAO) 호출
		//3.redirect(다른 controller호출)
		response.sendRedirect(request.getContextPath()+"/getStudent.jjdev");
	}

}
