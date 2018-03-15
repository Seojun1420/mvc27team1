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
		request.setCharacterEncoding("UTF-8");
		int teacherNo = (Integer.parseInt(request.getParameter("teacherNo")));//������ư�� �������� teacherNo ������ ����� ���� �����´�. int Ÿ���̱⶧���� ����ȯ�� ���ش�
		System.out.println(teacherNo+"<<�޾ƿ� ���̵�");
		TeacherDao teacherDao = new TeacherDao();
		Teacher teacher =teacherDao.TeacherSelectForUpdate(teacherNo);//teacherDao��  TeacherSelectForUpdate �޼��带 �����ϰ� �Ű�������  ���� teacherNo �� �Ѱ��ش�.
		request.setAttribute("teacher", teacher);//teacher���� request������ �����Ѵ�.
		request.getRequestDispatcher("/WEB-INF/views/modifyTeacherForm.jsp").forward(request, response);
		//request������ ������ ���� ����ϱ����� request.getRequestDispatcher()�޼��带����� forward�Ѵ�.
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int teacherNo = (Integer.parseInt(request.getParameter("teacherNo")));//������ư�� �������� teacherNo ������ ����� ���� �����´�. int Ÿ���̱⶧���� ����ȯ�� ���ش�
		String teacherId = request.getParameter("teacherId");//���� �Է��� ������ ID���� PW���� getParameter�޼��带 ����� �������� ���� ������ �����Ѵ�.
		String teacherPw = request.getParameter("teacherPw");
		System.out.println(teacherNo+","+teacherId+","+teacherPw);
		Teacher teacher =new Teacher();//Teacher ��ü�� �����ϰ� teacher��ü���������� �ּҸ� �Ҵ��Ѵ�.
		teacher.setTeacher_no(teacherNo);//Teacher��ü�� �¸޼��带����� ���� �������ش�.
		teacher.setTeacher_id(teacherId);
		teacher.setTeacher_pw(teacherPw);
		TeacherDao teacherDao = new TeacherDao();//TeacherDao ��ü�������ϰ� teacherDao��ü���������� �ּҸ� �Ҵ��Ѵ�.
		teacherDao.updateTeacher(teacher);//teacherDao ��ü�� updateTeacher �޼��带 �����ϰ� �Ű������� teacher�� �Ѱ��ش�.
		response.sendRedirect(request.getContextPath()+"/getTeacherList.jjev");
		//sendRedirect�� �̿��� �ش��η� �̵��Ѵ�.
		
	}

}
