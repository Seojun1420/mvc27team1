<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.Set"%>
<%@page import="model.TeacherAddr" %>
<%@page import="java.util.ArrayList" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
			$("#checkAll").click(function(){
				if($("#checkAll").prop("checked")){
					console.log('실행됨');
					$("input[name=check]").prop("checked",true);
				}else{
					$("input[name=check]").prop("checked",false);
				}
			})
		})
	</script>
	<title>getTeacherList</title>
</head>
<body>
	<div class="col-sm-3"></div>
	<div class="col-sm-6" >
		<h1 style="text-align:center;">GetTeacher List</h1>
		<form action="<%=request.getContextPath()%>/removeTeacherAddr.jjdev" method="post">
			<table class="table table-striped">
				<thead>
					<tr>
						<th><input type="checkbox" id="checkAll"><td>
						<th>회원번호</th>
						<th>Address</th>
					</tr>
				</thead>
			<%
				ArrayList<TeacherAddr> arrayList=(ArrayList<TeacherAddr>)(request.getAttribute("arrayList"));
				for(TeacherAddr teacherAddr:arrayList){
			%>
					<tbody>
						<tr>
							<td><input type="checkbox" name="check" size="1" value=<%=teacherAddr.getTeacherAddrNo()%>><td>
							<td><%=teacherAddr.getTeacherNo() %></td>
							<td><%=teacherAddr.getAddress() %></td>
						</tr>	
					</tbody>
			<%
				}
			%>
			</table>
			<input type="submit" value="삭제">
		</form>
	</div>
	<div class="col-sm-3"></div>
</body>
</html>