<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<script>
	      $(document).ready(function() {         
	         console.log("j쿼리시작");
	         if(${result} == 0){
	            alert("주소가등록되어 삭제할수 없습니다. 등록된주소를 모두 제거후 등록해주세요");
	         }
	      })
	   </script>
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
			<c:forEach var ="teacher" items="${ArrayList}">
				<tbody>
					<tr>
						<td>${teacher.teacher_no}</td>
						<td>${teacher.teacher_id}</td>
						<td>****</td>
						<td><a href="${pageContext.request.contextPath}/modifyTeacher.jjdev?teacherNo=${teacher.teacher_no}">수정</a></td>
						<td><a href="${pageContext.request.contextPath}/removeTeacher.jjdev?teacherNo=${teacher.teacher_no}" id="deleteClick" name="deleteClick">삭제</a></td>
						<td><span><a href="${pageContext.request.contextPath}/addAdressTeacher.jjdev?teacherNo=${teacher.teacher_no}">주소추가</a></span></td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>
	<div class="col-sm-3"></div>
</body>
</html>