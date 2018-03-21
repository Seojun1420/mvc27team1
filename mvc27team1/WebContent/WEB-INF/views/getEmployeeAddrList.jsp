<!-- mvc27team1 도정만  -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.EmployeeAddr" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script>
		$(document).ready(function(){
			console.log("체크1");
		    $("#checkAll").click(function(){
		    	console.log("체크2");
		        if($("#checkAll").prop("checked")){
		        	console.log("체크3");
		            $("input[name=check]").prop("checked",true);
		        }else{
		        	console.log("체크4");
		            $("input[name=check]").prop("checked",false);
		        }
		    })
		    $(".btn").click(function() {
		    	$("#form").submit();
		    });
		})
	</script>
	<title>Insert title here</title>
</head>
<body>
	<form id="form" action="<%= request.getContextPath() %>/removeEmployeeAddr.jjdev" method="post">
	<table border="1">
		<thead>
			<tr>
				<th><input type="checkbox" id="checkAll" ></th>
				<th>번호</th>
				<th>주소</th>
			</tr>
		</thead>

<%
	ArrayList<EmployeeAddr> list = (ArrayList<EmployeeAddr>)request.getAttribute("list");

	for(EmployeeAddr employeeAddr : list) {		
%>			
		
			<tbody>
			<tr>
				<td><input type="checkbox" name="check" value="<%= employeeAddr.getEmployeeAddrNo() %>"></td>
				<td><%= employeeAddr.getEmployeeNo() %></td>
				<td><%= employeeAddr.getAddress() %></td>						
			</tr>
			</tbody>	
		
					
<% 			
	}
%>
		<tr>

				<button type="button" class="btn">삭제하기</button>

		</tr>
	</table>
	</form>
</body>
</html>

