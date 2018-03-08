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
	            	$('#Helper').text("���̵� 6���̻��Է��Ͻÿ�");
	            	return;
	            }else if($('#StudentPw').val().length < 8) {
	            	$('#Helper').text("��й�ȣ 8���̻��Է��Ͻÿ�");
	            	return;
				}else if($('#StudentPwCheck').val().length <8){
					$('#Helper').text("Ȯ�κ�й�ȣ��  8���̻� �Է����ּ���");
					return;
				}else if($('#StudentPw').val() != $('#StudentPwCheck').val()) {
		               $('#Helper').text("��й�ȣ�� ���� �ʽ��ϴ�.");
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
					<input type="text" id="StudentId" name="StudentId"class="form-control" placeholder="���̵� �Է��Ͻÿ�."> 
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">Student_pw</label>
				<div class="col-sm-9">
				<input type="password" id="StudentPw" name="StudentPw" class="form-control" placeholder="�н����� �Է��Ͻÿ�."> 
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">Student_pwȮ��</label>
				<div class="col-sm-9">
					<input type="password" id="StudentPwCheck" name="StudentPwCheck" class="form-control" placeholder="�н����带 ��� Ȯ���ϼ���">
				</div>
			</div>
			<span id="Helper"></span>
			<div style="text-align:center;">
				<button id="btn" type="button" class="btn btn-primary btn-lg btn-block"> �л� �߰� </button>
			</div>
		</div>
		<div class="col-sm-3"></div>
	</form>


	
	
		      
		
	
</body>
</html>