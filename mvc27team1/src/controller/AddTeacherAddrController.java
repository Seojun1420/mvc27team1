package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TeacherAddr;
import model.TeacherAddrDao;


@WebServlet("/addAdressTeacher.jjdev")
public class AddTeacherAddrController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int teacherNo = (Integer.parseInt(request.getParameter("teacherNo")));//주소추가 눌렀을때 teacherNo 변수에 저장된 값을 가져온다. int 타입이기때문에 형변환을 해준다
		System.out.println(teacherNo);
		TeacherAddr teacherAddr =new TeacherAddr();
		TeacherAddrDao teacherAddrDao =new TeacherAddrDao();
		int count=teacherAddrDao.countTeacherAddr(teacherNo);
		
		if(count>=2) {
			request.setAttribute("teacherNo", teacherNo);
			request.getRequestDispatcher("/GetTeacherAddrListController").forward(request, response);
		}else {
			System.out.println("등록가능");
			teacherAddr.setTeacherNo(teacherNo);
			request.setAttribute("teacherAddr", teacherAddr);//teacherAddr값을 request영역에 셋팅한다.
			request.getRequestDispatcher("/WEB-INF/views/addAdressTeacherForm.jsp").forward(request, response);
			//request영역에 셋팅한 값을 사용하기위해 request.getRequestDispatcher()메서드를사용해 forward한다.
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String address = request.getParameter("address");//폼에 입력한 address값을 getParameter메서드를사용해 가져온뒤 변수에 저장한다.
		int teacherNo = (Integer.parseInt(request.getParameter("teacherNo")));
		System.out.println(address+"받아온 주소");
		System.out.println(teacherNo+"받아온 넘버");//teacherAddr객체안에 set메서드를사용해 값을 셋팅해준다.
		TeacherAddr teacherAddr =new TeacherAddr();
		TeacherAddrDao teacherAddrDao =new TeacherAddrDao();
		teacherAddr.setTeacherNo(teacherNo);
		teacherAddr.setAddress(address);
		
		teacherAddrDao.addTeacherAddr(teacherAddr);//TeacherAddrDao 객체를 생성하고 addAdressTeacher메서드를 실행하며 매개변수로teacherAddr준다.
		response.sendRedirect(request.getContextPath()+"/getTeacherList.jjev");
	}

}