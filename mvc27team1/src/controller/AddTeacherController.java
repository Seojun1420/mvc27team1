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

	//teacher 입력 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("/WEB-INF/views/addTeacher.jsp").forward(request, response);
	}

	//teacher 입력
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//form 에서 넘어온  id ,pw 의 입력값을 각각 변수에 저장하고 Teacher 객체에 각각 변수의 값을 셋팅해준다
		String teacherId = request.getParameter("teacherId");
		String teacherPw = request.getParameter("teacherPw");
		Teacher teacher = new Teacher();
		teacher.setTeacher_id(teacherId);
		teacher.setTeacher_pw(teacherPw);
		this.teacherDao = new TeacherDao();
		//teacherDao 의 insertTeacher 메서드를 실행해주고  매개변수로 teacher 를 준다.
		teacherDao.insertTeacher(teacher);
		//sendRedirect 를 이용해 해당경로로 간다.
		response.sendRedirect(request.getContextPath()+"/getTeacherList.jjev");
	}
}
