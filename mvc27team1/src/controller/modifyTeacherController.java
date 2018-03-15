package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teacher;
import model.TeacherDao;

@WebServlet("/modifyTeacher.jjdev")
public class modifyTeacherController extends HttpServlet {

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 수정");
		int teacherNo = (Integer.parseInt(request.getParameter("teacherNo")));
		System.out.println(teacherNo+"<<받아온 아이디");
		TeacherDao teacherDao = new TeacherDao();
		Teacher teacher =teacherDao.TeacherSelectForUpdate(teacherNo);
		request.setAttribute("teacher", teacher);
		request.getRequestDispatcher("/WEB-INF/views/modifyTeacherForm.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 수정");
		int teacherNo = (Integer.parseInt(request.getParameter("teacherNo")));
		String teacherId = request.getParameter("teacherId");
		String teacherPw = request.getParameter("teacherPw");
		System.out.println(teacherNo+","+teacherId+","+teacherPw);
		Teacher teacher =new Teacher();
		teacher.setTeacher_no(teacherNo);
		teacher.setTeacher_id(teacherId);
		teacher.setTeacher_pw(teacherPw);
		TeacherDao teacherDao = new TeacherDao();
		teacherDao.updateTeacher(teacher);
		response.sendRedirect(request.getContextPath()+"/getTeacherList.jjev");
		
	}

}
