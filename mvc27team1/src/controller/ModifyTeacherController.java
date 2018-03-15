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
public class ModifyTeacherController extends HttpServlet {

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 수정");
		int teacherNo = (Integer.parseInt(request.getParameter("teacherNo")));//수정버튼을 눌렀을때 teacherNo 변수에 저장된 값을 가져온다. int 타입이기때문에 형변환을 해준다
		System.out.println(teacherNo+"<<받아온 아이디");
		TeacherDao teacherDao = new TeacherDao();
		Teacher teacher =teacherDao.TeacherSelectForUpdate(teacherNo);//teacherDao의  TeacherSelectForUpdate 메서드를 실행하고 매개변수로  변수 teacherNo 를 넘겨준다.
		request.setAttribute("teacher", teacher);//teacher값을 request영역에 셋팅한다.
		request.getRequestDispatcher("/WEB-INF/views/modifyTeacherForm.jsp").forward(request, response);
		//request영역에 셋팅한 값을 사용하기위해 request.getRequestDispatcher()메서드를사용해 forward한다.
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 수정");
		int teacherNo = (Integer.parseInt(request.getParameter("teacherNo")));//수정버튼을 눌렀을때 teacherNo 변수에 저장된 값을 가져온다. int 타입이기때문에 형변환을 해준다
		String teacherId = request.getParameter("teacherId");//폼에 입력한 수정한 ID값과 PW값을 getParameter메서드를 사용해 가져오고 각각 변수에 저장한다.
		String teacherPw = request.getParameter("teacherPw");
		System.out.println(teacherNo+","+teacherId+","+teacherPw);
		Teacher teacher =new Teacher();//Teacher 객체를 생성하고 teacher객체참조변수에 주소를 할당한다.
		teacher.setTeacher_no(teacherNo);//Teacher객체의 셋메서드를사용해 값을 셋팅해준다.
		teacher.setTeacher_id(teacherId);
		teacher.setTeacher_pw(teacherPw);
		TeacherDao teacherDao = new TeacherDao();//TeacherDao 객체를생성하고 teacherDao객체참조변수에 주소를 할당한다.
		teacherDao.updateTeacher(teacher);//teacherDao 객체에 updateTeacher 메서드를 실행하고 매개변수로 teacher를 넘겨준다.
		response.sendRedirect(request.getContextPath()+"/getTeacherList.jjev");
		//sendRedirect를 이용해 해당경로로 이동한다.
		
	}

}
