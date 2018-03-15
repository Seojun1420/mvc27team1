<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<%@ page import="model.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>modifyEmployeeForm.jsp</title>
</head>
<body>
	수정화면
<%
	Employee employee = (Employee)request.getAttribute("employee");
%>
	<form action="<%=request.getContextPath() %>/modifyEmployee.jjdev" method="post">
		<table border="1">
		<tr>
			<td>회원번호</td>
			<td><input type="text" name="modifyEmployeeNo" value="<%=employee.getEmployee_no()%>" readonly></td>
		<tr>
			<td>회원아이디</td>
			<td><input type="text" name="modifyEmployeeId" value="<%=employee.getEmployee_id()%>"></td>
		<tr>
			<td>회원패스워드</td>
			<td><input type="text" name="modifyEmployeePw" value="<%=employee.getEmployee_pw()%>"></td>
		<tr>
			<td ><input type="submit" value="수정하기"></td>
		</tr>
	</table>
	</form>

</body>
</html>