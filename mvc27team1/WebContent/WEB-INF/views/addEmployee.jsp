<!-- mvc27team1 도정만  -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	
	<style>	
		.row{margin: 15rem auto !important;}
		h1{text-align: center; color: white !important;}
		body{padding: 0rem; margin: 0; background-image: url(http://datools.kr/zeroboard/data/photo/lala1217_88.jpg); background-size: cover;}
		.panel{margin-bottom:0 !important;}
		h2{text-align: center;}
		.input-group{margin-bottom: 5px !important;}
		.error{text-align: center; color: red; font-size: 3rem;}
		#pb{color: red !importan;}
	</style>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			//폼 유효성 검사 후 폼을 submit
			
			var uId = ('.addEmployeeId'); 
			$('.btn').click(function(){
				if($('.addEmployeeId').val().length < 4) {
					$('.error').text("아이디 4자이상 입력하시오");
					$('.addEmployeeId').focus();
					return;
				}else if($('.addEmployeePw').val().length < 4) {
					$('.error').text("비밀번호 4자이상 입력하시오");
					$('.addEmployeePw').focus();
					return;
				}else if($('.addEmployeePw').val() != $('#addEmployeePwCheck').val()) {
					//addEmployeePw 안의 value값을 비교해야함
					$('.error').text("입력하신 비밀번호와 동일하지 않습니다.");
					$('.addEmployeePwCheck').focus();
					return;
				}else {
					$('#loginForm').submit();					
				}				
			});
		});
	</script>
</head>
<body>	
	<div class="row">
		<h1>addEmployee</h1>
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="panel panel-default">
				<form id="loginForm" method="post" action="./addEmployee.jjdev">
				<div id="pb" class="pb panel-body form-horizontal" >
					<div class="form-group">
						<label class="col-sm-3 control-label for=id">employee_id : </label>
						<div class="col-sm-9">
							<input type="text" class="addEmployeeId form-control" id="addEmployeeId" name="addEmployeeId">
						</div>						
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label for=pw">employee_pw : </label>
						<div class="col-sm-9">
							<input type="text" class="addEmployeePw form-control" id="addEmployeePw" name="addEmployeePw">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label for=pwCheck">employee_pw확인 : </label>
						<div class="col-sm-9">
							<input type="text" class="addEmployeePwCheck form-control" id="addEmployeePwCheck" name="addEmployeePwCheck">
						</div>
					</div>
					<div id="error" class="error"></div>
					<div>
						<button type="button" class="btn btn-primary btn-block">직원 입력</button>
					</div>									
				</div>	
				</form>				
			</div>
		<div class="col-sm-3"></div>			
		</div>
	</div>
	
</body>
</html>