<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>addStudent</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<style>
	h1{text-align: center; color: blue !important;}
	
	</style>
	<script>
		$(document).ready(function(){
			$('#btn').click(function(){
	            if($('#StudentId').val().length < 6) {
	            	$('#Helper').text("아이디 6자이상입력하시오");
	            	return;
	            }else if($('#StudentPw').val().length < 8) {
	            	$('#Helper').text("비밀번호 8자이상입력하시오");
	            	return;
				}else if($('#StudentPwCheck').val().length <8){
					$('#Helper').text("확인비밀번호를  8자이상 입력해주세요");
					return;
				}else if($('#StudentPw').val() != $('#StudentPwCheck').val()) {
		               $('#Helper').text("비밀번호가 맞지 않습니다.");
		               return;
				}else{
					$('#myForm').submit();
				}
	         });
	      });
	</script>
</head>
<body>
	<h1>addStudent</h1>
	<form id="myForm" method="post" action="<%=request.getContextPath()%>/addStudent.jjdev" class="form-horizontal">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-sm-3 control-label">Student_id</label>
				<div class="col-sm-9">
					<input type="text" id="StudentId" name="StudentId"class="form-control" placeholder="아이디 입력하시오."> 
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">Student_pw</label>
				<div class="col-sm-9">
				<input type="password" id="StudentPw" name="StudentPw" class="form-control" placeholder="패스워드 입력하시오."> 
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">Student_pw확인</label>
				<div class="col-sm-9">
					<input type="password" id="StudentPwCheck" name="StudentPwCheck" class="form-control" placeholder="패스워드를 디시 확인하세요">
				</div>
			</div>
			<span id="Helper"></span>
			<div style="text-align:center;">
				<button id="btn" type="button" class="btn btn-primary btn-lg btn-block"> 학생 추가 </button>
			</div>
		</div>
		<div class="col-sm-3"></div>
	</form>


	
	
		      
		
	
</body>
</html>