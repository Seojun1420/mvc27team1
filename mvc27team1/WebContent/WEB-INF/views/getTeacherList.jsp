<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.Set"%>
<%@page import="model.Teacher" %>
<%@page import="java.util.ArrayList" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
					<th>회원ID</th>
					<th>회원PW</th>
					<th>수정</th>
					<th>삭제</th>
					<th>ADD TEACHER_ADD</th>
				</tr>
			</thead>
		<%
			int count=0;
			if(request.getAttribute("count")!=null){
				count=(int)request.getAttribute("count");
			}
			ArrayList<Teacher> arrayList=(ArrayList<Teacher>)(request.getAttribute("ArrayList"));
			for(Teacher teacher:arrayList){
		%>
				<tbody>
					<tr>
						<td><%=teacher.getTeacher_no() %></td>
						<td><%=teacher.getTeacher_id() %></td>
						<td>****</td>
						<td><a href="<%=request.getContextPath()%>/modifyTeacher.jjdev?teacherNo=<%=teacher.getTeacher_no()%>">수정</a></td>
						<td><a href="<%=request.getContextPath()%>/removeTeacher.jjdev?teacherNo=<%=teacher.getTeacher_no()%>">삭제</a></td>
						<td><span><a href="<%=request.getContextPath()%>/addAdressTeacher.jjdev?teacherNo=<%=teacher.getTeacher_no()%>">주소추가</a></span></td>
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