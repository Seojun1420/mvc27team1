<!-- mvc27team1 도정만  -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.EmployeeAddr" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>주소</th>
			</tr>
		</thead>
<%
	ArrayList<EmployeeAddr> list = (ArrayList<EmployeeAddr>)request.getAttribute("list");
	System.out.println(list.size()+"<---list싸이즈");
	for(EmployeeAddr employeeAddr : list) {		
%>			
		<tbody>
			<tr>
				<td><%= employeeAddr.getEmployeeNo() %></td>
				<td><%= employeeAddr.getAddress() %></td>						
			</tr>
		</tbody>				
<% 			
	}
%>
	</table>
</body>
</html>

