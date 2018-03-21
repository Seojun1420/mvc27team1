package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TeacherAddr;
import model.TeacherAddrDao;


@WebServlet("/getTeacherAddrList.jjdev")
public class GetTeacherAddrListController extends HttpServlet {

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		int teacherNo =(int)request.getAttribute("teacherNo");
		System.out.println(teacherNo);
		TeacherAddrDao teacherAddrDao = new TeacherAddrDao();
		ArrayList<TeacherAddr> arrayList=teacherAddrDao.selectTeacherAddr(teacherNo);
		request.setAttribute("arrayList", arrayList);
		request.getRequestDispatcher("/WEB-INF/views/getTeacherAddrList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
