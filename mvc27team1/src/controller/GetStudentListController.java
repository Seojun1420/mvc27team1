package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentDao;

@WebServlet ("/getStudent.jjdev")
public class GetStudentListController extends HttpServlet {
	private StudentDao studentDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.studentDao = new StudentDao();
		// StudentDao studentDao = new StudentDao();
		// Student student = new Student();
		ArrayList<Student> arrayList = new ArrayList<Student>();
		arrayList=studentDao.selectStudent();
		request.setAttribute("ArrayList", arrayList);
		request.getRequestDispatcher("/WEB-INF/views/getStudentList.jsp").forward(request, response);
		System.out.println("StudentId & StudentPw가 정상적으로 입력되었습니다.");
	}

}
