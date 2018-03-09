<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>addTeacher</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<style>
	body{
	background: url(http://www.timurtek.com/wp-content/uploads/2014/10/form-bg.jpg) no-repeat center center fixed;
	-webkit-background-size: cover;
  	background-size: cover;
  	}
	
	</style>
	<script>
		$(document).ready(function(){
			$('#btn').click(function(){
				if($('#teacherId').val().length < 4) {
					$('#banHelper').text("아이디 4자이상입력하시오");
					return;
				}else if($('#teacherPw').val().length < 4) {
					$('#banHelper').text("비밀번호 4자이상입력하시오");
					return;
				}else if($('#teacherPwCheck').val().length <4){
					$('#banHelper').text("확인비밀번호를 4자이상 입력해주세요");
					return;
				}else if($('#teacherPw').val() != $('#teacherPwCheck').val()) {
					$('#banHelper').text("비밀번호가 맞지 않습니다.");
					return;
				}else{
					$('#myForm').submit();
					}
			});
		});
	</script>
</head>
<body>
	<h1 style="text-align:center;">addTeacher</h1>
	<form id="myForm" method="post" action="<%=request.getContextPath()%>/addTeacher.jjdev" class="form-horizontal">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-sm-3 control-label">teacher_id</label>
				<div class="col-sm-9">
					<input type="text" id="teacherId" name="teacherId"class="form-control" placeholder="ID입력"> 
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">teacher_pw</label>
				<div class="col-sm-9">
				<input type="password" id="teacherPw" name="teacherPw" class="form-control" placeholder="PW입력"> 
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">teacher_pw확인</label>
				<div class="col-sm-9">
					<input type="password" id="teacherPwCheck" name="teacherPwCheck" class="form-control" placeholder="PW확인">
				</div>
			</div>
			<span id="banHelper"></span>
			<div style="text-align:center;">
				<button id="btn" type="button" class="btn btn-default">게스트추가</button>
			</div>
		</div>
		<div class="col-sm-3"></div>
	</form>
</body>
</html>