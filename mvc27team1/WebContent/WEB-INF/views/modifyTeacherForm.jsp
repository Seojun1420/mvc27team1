<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="model.Teacher" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<title>modifyTeacherForm</title>
</head>
<body>
	<div class="col-sm-3"></div>
	<div class="col-sm-6">
		<h1 style="text-align:center;">GetTeacher Modify</h1>
		<form action="<%=request.getContextPath()%>/modifyTeacher.jjdev" method="post">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>회원번호</th>
						<th>회원ID</th>
						<th>회원PW</th>
					</tr>
				</thead>
				<%
					Teacher teacher = (Teacher)request.getAttribute("teacher");
				%>
				<tbody>
					<tr>
						<td><input type="text" name="teacherNo" value=<%=teacher.getTeacher_no() %> readonly></td>
						<td><input type="text" name="teacherId" value=<%=teacher.getTeacher_id() %>></td>
						<td><input type="text" name="teacherPw" value=<%=teacher.getTeacher_pw() %>></td>
					</tr>	
					<tr>
						<td><input type="submit" value="수정하기"></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<div class="col-sm-3"></div>
</body>
</html>