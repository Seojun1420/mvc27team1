<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<title>addAdressTeacher</title>
</head>

<body>
	<div class="col-sm-3"></div>
	<div class="col-sm-6">
		<h1 style="text-align:center;">AddAdressTeacher</h1>
		<form action="${pageContext.request.contextPath}/addAdressTeacher.jjdev" method="post">
			<table class="table table-striped">
				<thead>
					<tr>
						<td>회원번호</td>
						<td>주소</td>
					</tr>
				</thead>
				<tbody>
					<input type="hidden" name="teacherNo" value="${teacherAddr.teacherNo}">
					<tr>
						<td>${teacherAddr.teacherNo}</td>
						<td><input type="text" name="address"></td>
					</tr>
					<tr>
						<td><input type="submit" value="주소추가"></td>
					</tr>
				</tbody>
			</table>
		</form>
		<div class="col-sm-3"></div>
	</div>
</body>
</html>