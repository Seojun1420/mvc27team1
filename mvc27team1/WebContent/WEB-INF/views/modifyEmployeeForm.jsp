<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="model.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>modifyEmployeeForm.jsp</title>
</head>
<body>
	����ȭ��
<%
	Employee employee = (Employee)request.getAttribute("employee");
%>
	<form action="<%=request.getContextPath() %>/modifyEmployee.jjdev" method="post">
		<table border="1">
		<tr>
			<td>ȸ����ȣ</td>
			<td><input type="texe" name="modifyEmployeeNo" value="<%=employee.getEmployee_no()%>" readonly></td>
		<tr>
			<td>ȸ�����̵�</td>
			<td><input type="texe" name="modifyEmployeeId" value="<%=employee.getEmployee_id()%>"></td>
		<tr>
			<td>ȸ����ȣ</td>
			<td><input type="texe" name="modifyEmployeePw" value="<%=employee.getEmployee_pw()%>"></td>
		<tr>
			<td ><input type="submit" value="�����ϱ�"></td>
		</tr>
	</table>
	</form>

</body>
</html>