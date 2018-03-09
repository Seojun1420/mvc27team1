<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.Set"%>
<%@page import="model.Teacher" %>
<%@page import="java.util.ArrayList" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<title>Insert title here</title>
</head>
<body>
	<div class="col-sm-3"></div>
	<div class="col-sm-6">
		<h1 style="text-align:center;">GetTeacher List</h1>
		<table class="table table-striped">
			<tr>
				<th>회원번호</th>
				<th>회원ID</th>
				<th>회원PW</th>
			</tr>
		<%
			ArrayList<Teacher> arrayList=(ArrayList<Teacher>)(request.getAttribute("ArrayList"));
			for(Teacher arr:arrayList){
		%>
			<tr>
				<td><%=arr.getNum() %></td>
				<td><%=arr.getId() %></td>
				<td><%=arr.getPw() %></td>
			</tr>
		<%
			}
		%>
		</table>
	</div>
	<div class="col-sm-3"></div>
</body>
</html>