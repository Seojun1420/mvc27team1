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
public class AddAdressTeacherController extends HttpServlet {
	TeacherAddr teacherAddr = null;
	TeacherAddrDao teacherAddrDao = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int teacherNo = (Integer.parseInt(request.getParameter("teacherNo")));//�ּ��߰� �������� teacherNo ������ ����� ���� �����´�. int Ÿ���̱⶧���� ����ȯ�� ���ش�
		System.out.println(teacherNo);
		teacherAddr =new TeacherAddr();
		teacherAddrDao =new TeacherAddrDao();
		int count=teacherAddrDao.countTeacherAddr(teacherNo);
		
		if(count>=2) {
			request.setAttribute("count", count);
			request.getRequestDispatcher("/getTeacherList.jjev").forward(request, response);
		}else {
			System.out.println("��ϰ���");
			teacherAddr.setTeacherNo(teacherNo);
			request.setAttribute("teacherAddr", teacherAddr);
			System.out.println("DDDDD");//teacherAddr���� request������ �����Ѵ�.
			request.getRequestDispatcher("/WEB-INF/views/addAdressTeacherForm.jsp").forward(request, response);
			//request������ ������ ���� ����ϱ����� request.getRequestDispatcher()�޼��带����� forward�Ѵ�.
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String address = request.getParameter("address");//���� �Է��� address���� getParameter�޼��带����� �����µ� ������ �����Ѵ�.
		int teacherNo = (Integer.parseInt(request.getParameter("teacherNo")));
		System.out.println(address+"�޾ƿ� �ּ�");
		System.out.println(teacherNo+"�޾ƿ� �ѹ�");//teacherAddr��ü�ȿ� set�޼��带����� ���� �������ش�.
		teacherAddr =new TeacherAddr();
		teacherAddrDao =new TeacherAddrDao();
		teacherAddr.setTeacherNo(teacherNo);
		teacherAddr.setAddress(address);
		
		teacherAddrDao.addAdressTeacher(teacherAddr);//TeacherAddrDao ��ü�� �����ϰ� addAdressTeacher�޼��带 �����ϸ� �Ű�������teacherAddr�ش�.
		response.sendRedirect(request.getContextPath()+"/getTeacherList.jjev");
	}

}
