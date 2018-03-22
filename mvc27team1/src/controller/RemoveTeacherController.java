package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TeacherDao;


@WebServlet("/removeTeacher.jjdev")
public class RemoveTeacherController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RemoveTeacherController 실행");
		request.setCharacterEncoding("UTF-8");
		int teacherNo = (Integer.parseInt(request.getParameter("teacherNo")));
		System.out.println(teacherNo);
		TeacherDao teacherDao = new TeacherDao();
		request.setAttribute("result", teacherDao.deleteTeacher(teacherNo));
		//response.sendRedirect(request.getContextPath()+"/getTeacherList.jjev");
		request.getRequestDispatcher("/getTeacherList.jjev").forward(request, response);
	}
}
