package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TeacherAddrDao;


@WebServlet("/removeTeacherAddr.jjdev")
public class RemoveTeacherAddrController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/removeTeacherAddr.jjdev doPost");
		String[]arr=request.getParameterValues("check");//체크박스가 체크된값을 배열로 받아와 String 배열에 담는다.
		int[] checkArr =null;//int 타입으로 바꿔주기위해 int 배열선언
		if(arr!=null) {//만약 arr이가 널이아니면 실행
			checkArr = new int[arr.length];//int 타입의 배열 checkArr 이 공간을 arr.length만큼 생성
			for(int i=0;i<arr.length;i++) {//string 타입을 int 타입으로변환해 값을 저장
				checkArr[i] = Integer.parseInt(arr[i]);
				System.out.println(checkArr[i]);
			}	
		}
		TeacherAddrDao teacherAddrDao = new TeacherAddrDao();//TeacherAddrDao 객체생성후 
		teacherAddrDao.removeTeacherAddr(checkArr);//removeTeacherAddr메서드실행 매개변수로(checkArr)넘김
		response.sendRedirect(request.getContextPath()+"/getTeacherList.jjev");
	}

}
