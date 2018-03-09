<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>addStudent</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
	<style>
	
	body{
    background:url(https://www.squiz.net/__public/Systems/Perspective/FileCache/1-32000/465/prop/header-bg-image.jpg?t=1472431690);
    padding:70px;
    
	}
	h1{text-align: center;}
	h2{color: black !important;}
	label{color: black !important;}
	
	
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
	<h1>AddStudent</h1>

<form id="myForm" method="post" action="<%=request.getContextPath()%>/addStudent.jjdev">
	<div id="loginModal" class="모달 쇼" tabindex="-2" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		  <div class="modal-content">
		  <div class="modal-header">
		    <button type="button" class="close" data-dismiss="모달 " aria-hidden="true">×</button>
		      <h2 class="text-center">AddStudent</h2>
		       <div class="modal-body">
		      <form class="form col-md-15 center-block">
					<div class="col-sm-10"></div>
					<div class="col-sm-14">
			<div class="form-group">
				<label class="col-sm-3 control-label">Student_Id</label>
				<div class="col-sm-9">
					<input type="text" id="StudentId" name="StudentId"class="form-control" placeholder="아이디 입력하시오."> 
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">Student_Pw</label>
				<div class="col-sm-9">
				<input type="password"id="StudentPw" name="StudentPw" class="form-control" placeholder="패스워드 입력하시오."> 
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">Student_Pw확인</label>
				<div class="col-sm-9">
					<input type="password"  id="StudentPwCheck" name="StudentPwCheck" class="form-control" placeholder="패스워드를 디시 확인하세요">
				</div>
			</div>
			<span id="Helper"></span>
			<div style="text-align:center;">
				<button id="btn" type="button" class="btn btn-primary btn-lg btn-block"> 학생 추가 </button>
			
			</div>
			
		</div>
		
		<div class="col-sm-2"></div>
	</form>
				</div>
				 <div class="modal-footer">
          <div class="col-md-12">
          <button class="btn" data-dismiss="모달" aria-hidden="true">취소</button>
		  </div>
			</div>
			
		</div>
	</div>
</div>
</form>

	
	
		      
		
	
</body>
</html>