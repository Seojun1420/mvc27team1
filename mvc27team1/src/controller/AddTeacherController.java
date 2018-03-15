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
public class AddTeacherController extends HttpServlet {
	private TeacherDao teacherDao;

	//teacher �Է� ��
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("/WEB-INF/views/addTeacher.jsp").forward(request, response);
	}

	//teacher �Է�
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//form ���� �Ѿ��  id ,pw �� �Է°��� ���� ������ �����ϰ� Teacher ��ü�� ���� ������ ���� �������ش�
		String teacherId = request.getParameter("teacherId");
		String teacherPw = request.getParameter("teacherPw");
		Teacher teacher = new Teacher();
		teacher.setTeacher_id(teacherId);
		teacher.setTeacher_pw(teacherPw);
		this.teacherDao = new TeacherDao();
		//teacherDao �� insertTeacher �޼��带 �������ְ�  �Ű������� teacher �� �ش�.
		teacherDao.insertTeacher(teacher);
		//sendRedirect �� �̿��� �ش��η� ����.
		response.sendRedirect(request.getContextPath()+"/getTeacherList.jjev");
	}
}
