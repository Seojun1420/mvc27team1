<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@page import="model.Teacher" %>
<%@page import="java.util.ArrayList" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
<div class="col-sm-3"></div>
<div class="col-sm-6">
<h1 style="text-align:center;">GetTeacher List</h1>
<table class="table table-striped">
	<tr>
		<th>ȸ����ȣ</th>
		<th>ȸ��ID</th>
		<th>ȸ��PW</th>
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