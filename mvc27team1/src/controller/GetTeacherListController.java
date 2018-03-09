package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teacher;
import model.TeacherDao;

@WebServlet("/getTeacherList.jjev")
public class GetTeacherListController extends HttpServlet {
	private TeacherDao teacherDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.teacherDao = new TeacherDao();
		//Teacher teacher = new Teacher();
		ArrayList<Teacher> arrayList = new ArrayList<Teacher>();
		arrayList=teacherDao.selectTeacher();
		for(Teacher arr:arrayList) {
			System.out.println(arr.getId());
		}
		request.setAttribute("ArrayList", arrayList);
		request.getRequestDispatcher("/WEB-INF/views/getTeacherList.jsp").forward(request, response);
	}

}
