package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teacher;
import model.TeacherDao;


@WebServlet("/addTeacher.jjdev")
public class teacherController extends HttpServlet {


	//teacher �Է� ��
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/addTeacher.jsp").forward(request, response);
	}

	//teacher �Է�
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("teacherId");
		String pw=request.getParameter("teacherPw");
		System.out.println(id+"�ԷµȾ��̵�");
		
	
		//1.request ó��
		//2.�� (DAO) ȣ��
		//3.�ٸ� controller ȣ�� (redirect)
	}

}
