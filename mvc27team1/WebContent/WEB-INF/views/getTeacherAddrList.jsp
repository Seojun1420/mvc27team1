<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.Set"%>
<%@page import="model.TeacherAddr" %>
<%@page import="java.util.ArrayList" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<title>getTeacherList</title>

</head>
<body>
	<div class="col-sm-3"></div>
	<div class="col-sm-6" >
		<h1 style="text-align:center;">GetTeacher List</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>회원번호</th>
					<th>Address</th>
				</tr>
			</thead>
		<%
			int count=0;
			if(request.getAttribute("count")!=null){
				count=(int)request.getAttribute("count");
			}
			ArrayList<TeacherAddr> arrayList=(ArrayList<TeacherAddr>)(request.getAttribute("arrayList"));
			for(TeacherAddr teacherAddr:arrayList){
		%>
				<tbody>
					<tr>
						<td><%=teacherAddr.getTeacherNo() %></td>
						<td><%=teacherAddr.getAddress() %></td>
					</tr>	
				</tbody>
		<%
			}
		%>
		</table>
	</div>
	<div class="col-sm-3"></div>
</body>
</html>