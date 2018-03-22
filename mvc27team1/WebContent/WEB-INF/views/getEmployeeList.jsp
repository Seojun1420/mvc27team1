<!-- mvc27team1 도정만  -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<title>Insert title here</title>
	<script>
		$(document).ready(function() {			
			console.log("j쿼리시작");
			if(${result} == 0){
				alert("주소가등록되어 삭제할수 없습니다. 등록된주소를 모두 제거후 등록해주세요");
			}
		})
	</script>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>비번</th>
				<th>수정</th>
				<th>삭제</th>
				<th>ADD EMPLOYEE_ADD</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="employee" items="${list}">
				<tr>
					<td>${employee.employee_no}</td>
					<td>${employee.employee_id}</td>
					<td>****</td>
					<td><a href="${pageContext.request.contextPath}/modifyEmployee.jjdev?employeeNo=${employee.employee_no}">수정</a></td>
					<td><a href="${pageContext.request.contextPath}/removeEmployee.jjdev?employeeNo=${employee.employee_no}">삭제</a><span class="rHelper"></span></td>
					<td><a href="${pageContext.request.contextPath}/addAddressEmployee.jjdev?employeeNo=${employee.employee_no}">주소추가</a></td>								
				</tr>
			</c:forEach>			
		</tbody>				
	</table>
</body>
</html>