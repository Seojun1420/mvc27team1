package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TeacherAddr;
import model.TeacherAddrDao;


@WebServlet("/addAdressTeacher.jjdev")
public class addAdressTeacherController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget");
		int teacherNo = (Integer.parseInt(request.getParameter("teacherNo")));
		System.out.println(teacherNo);
		TeacherAddr teacherAddr = new TeacherAddr();
		teacherAddr.setTeacherNo(teacherNo);
		request.setAttribute("teacherAddr", teacherAddr);
		request.getRequestDispatcher("/WEB-INF/views/addAdressTeacherForm.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("dopost");
		String address = request.getParameter("address");
		int teacherNo = (Integer.parseInt(request.getParameter("teacherNo")));
		System.out.println(address+"받아온 주소");
		System.out.println(teacherNo+"받아온 넘버");
		TeacherAddr teacherAddr = new TeacherAddr();
		teacherAddr.setTeacherNo(teacherNo);
		teacherAddr.setAddress(address);
		
		TeacherAddrDao teacherAddrDao = new TeacherAddrDao();
		teacherAddrDao.addAdressTeacher(teacherAddr);
		response.sendRedirect(request.getContextPath()+"/getTeacherList.jjev");
	}

}
