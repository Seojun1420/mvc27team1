<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>addstudent</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>	

	<script>
	var studentBtn = document.getElementById("studentBtn");
		studentBtn.addEventListener("click", function(){
			if(document.getElementById("studentId").value == ""){
				alert("학생 ID를 입력하세요");
			} else if(document.getElementById("studentPw").value == ""){
				alert("학생 PW를 입력하세요");
			}
			var studentForm = document.getElementById("studentForm");
			studentForm.submit();
		});
	$(document).ready(function(){
		if(document.get)
		//폼 유효성 검사
		//
	});
	</script>
</head>
<body>
		<h1> addstudent </h1>
		<form id="studentForm" method="post" action="<%=request.getContextPath()%>/addstudent.jjdev">
		<tr> 
			<td> student_id : </td> 
				<td><input type="text" id="studentId" name="studentId" class=""><br></td>
			<td> student_pw : </td> 
				<td><input type="password" id="studentPw" name="studentPw" class=""><br></td>
			<td> student_pw확인 : </td>
			<td><input type="password" id="studentPwCheck" name="studentPwCheck" class=""></td>
			<button type="button" id="studentBtn">학생 추가</button>
		</tr>
		</form>
		
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>