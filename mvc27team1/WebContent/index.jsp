<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	response.sendRedirect(request.getContextPath()+"/getTeacherList.jjev");

%>
<%-- 1. jsp 지시자 :<%@%>
2. jsp 표현식 :<%=%>
 EL사용
 <%=request.getAttribute("x")%> ->${x}
 <%=session.getAttribute("y")%> ->${y}
 <%=m.getNo()%> ->${m.no} --%>
 