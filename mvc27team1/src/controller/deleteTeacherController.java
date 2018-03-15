package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TeacherDao;


@WebServlet("/deleteTeacher.jjdev")
public class deleteTeacherController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget");
		int teacherNo = (Integer.parseInt(request.getParameter("teacherNo")));
		System.out.println(teacherNo);
		TeacherDao teacherDao = new TeacherDao();
		teacherDao.deleteTeacher(teacherNo);
		response.sendRedirect(request.getContextPath()+"/getTeacherList.jjev");
		
	}
}
