package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/addStudent.jjdev" })
public class studentcontroller extends HttpServlet {
	// student 입력폼 요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/addStudent.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.request.처리 
		String id=request.getParameter("StudentId");
		String pw=request.getParameter("StudentPw");
		System.out.println(id+"입력된아이디");
		
		//2.모델(DAO) 호출
		//3.redirect(다른 controller호출)
	}

}
