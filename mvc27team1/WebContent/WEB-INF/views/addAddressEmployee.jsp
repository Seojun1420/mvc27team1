<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>addAddressEmployee.jsp</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/addAddressEmployee.jjdev" method="post">
		<table border="1">
		<tr>
			<td>회원넘버</td>
			<td><input type="text" name="employeeNo" value="${employeeNo}"></td>
		<tr>
			<td>회원주소</td>
			<td><input type="text" name="employeeAddr"></td>
		<tr>
			<td ><input type="submit" value="주소추가하기"></td>
		</tr>
	</table>
	</form>
</body>
</html>