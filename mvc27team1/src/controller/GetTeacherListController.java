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
		System.out.println("메서드실행");
		request.setCharacterEncoding("UTF-8");
		this.teacherDao = new TeacherDao();
		
		int pageRerRow = 2;
		int currentPage = 1;
		if(request.getParameter("currentPage")!=null) {
			currentPage = (Integer.parseInt(request.getParameter("currentPage")));
		}
		int startRow = (currentPage-1)*pageRerRow;
		ArrayList<Teacher> arrayList = teacherDao.selectTeacher(startRow,pageRerRow);
		int tatalRowCount= teacherDao.teacherRowCount();
		int lastPage = tatalRowCount/pageRerRow;
		if(tatalRowCount%pageRerRow!=0) {
			lastPage++;
		}
		request.setAttribute("ArrayList", arrayList);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lastPage", lastPage);
		request.getRequestDispatcher("/WEB-INF/views/getTeacherList.jsp").forward(request, response);
	}

}
