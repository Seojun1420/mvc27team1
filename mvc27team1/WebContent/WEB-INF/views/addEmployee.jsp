<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	
	<style>	
		.row{margin: 15rem auto !important;}
		h1{text-align: center; color: white !important;}
		body{padding: 0rem; margin: 0; background-image: url(http://datools.kr/zeroboard/data/photo/lala1217_88.jpg); background-size: cover;}
		.panel{margin-bottom:0 !important;}
		h2{text-align: center;}
		.input-group{margin-bottom: 5px !important;}
		.error{text-align: center; color: red; font-size: 30px;}
	</style>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			//�� ��ȿ�� �˻� �� ���� submit
			
			var uId = ('.addEmployeeId'); 
			$('.btn').click(function(){
				if($('.addEmployeeId').val().length < 4) {
					$('.error').text("���̵� 4���̻��Է��Ͻÿ�");
					$('.addEmployeeId').focus();
					return;
				}else if($('.addEmployeePw').val().length < 4) {
					$('.error').text("��й�ȣ 4���̻��Է��Ͻÿ�");
					$('.addEmployeePw').focus();
					return;
				}else if($('.addEmployeePw').val() != $('#addEmployeePwCheck').val()) {
					//addEmployeePw ���� value���� ���ؾ���
					$('.error').text("�Է��Ͻ� ��й�ȣ�� �������� �ʽ��ϴ�.");
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
				<div class="panel-body form-horizontal" >
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
						<label class="col-sm-3 control-label for=pwCheck">employee_pwȮ�� : </label>
						<div class="col-sm-9">
							<input type="text" class="addEmployeePwCheck form-control" id="addEmployeePwCheck" name="addEmployeePwCheck">
						</div>
					</div>
					<div id="error" class="error"></div>
					<div>
						<button type="button" class="btn btn-primary btn-block">���� �Է�</button>
					</div>									
				</div>	
				</form>				
			</div>
		<div class="col-sm-3"></div>			
		</div>
	</div>
	
</body>
</html>