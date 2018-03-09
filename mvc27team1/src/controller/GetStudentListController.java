package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet ("/getStudent.jjdev")
public class GetStudentListController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/getStudentList.jsp").forward(request, response);
		// request...
		// StudentDao
		// request에 속성 추가
		// forward
		System.out.println("StudentId & StudentPw가 정상적으로 입력되었습니다.");
	}

}
