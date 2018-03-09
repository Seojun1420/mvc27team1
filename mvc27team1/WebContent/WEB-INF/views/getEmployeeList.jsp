<!-- mvc27team1 도정만  -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Employee" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>비번</th>
			</tr>
		</thead>
<%
 ArrayList<Employee> list = (ArrayList<Employee>) request.getAttribute("Employee");
	for(Employee employee : list) {		
%>
			
		<tbody>
			<tr>
				<td><%= employee.getEmployee_no() %></td>
				<td><%= employee.getEmployee_id() %></td>
				<td><%= employee.getEmployee_pw() %></td>
			</tr>
		</tbody>				
<% 			
}
%>		
	</table>
</body>
</html>