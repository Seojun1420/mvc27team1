<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addAddressEmployee.jsp</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/modifyEmployee.jjdev" method="post">
		<table border="1">
		<tr>
			<td>회원번호</td>
			<td><input type="text" name="modifyEmployeeNo" value="<%=%>" readonly></td>
		<tr>
			<td>회원아이디</td>
			<td><input type="text" name="modifyEmployeeId" value="<%=%>"></td>
		<tr>
			<td>회원번호</td>
			<td><input type="text" name="modifyEmployeePw" value="<%=%>"></td>
		<tr>
			<td ><input type="submit" value="수정하기"></td>
		</tr>
	</table>
	</form>
</body>
</html>