<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>	
	.row{margin: 15rem auto !important;}
	h1{text-align: center; color: white !important;}
	body{padding: 0rem; margin: 0; background-image: url(http://datools.kr/zeroboard/data/photo/lala1217_88.jpg); background-size: cover;}
	.panel{margin-bottom:0 !important;}
	h2{text-align: center;}
	.input-group{margin-bottom: 5px !important;}
	#helper{display: block; border: 1px solid red; }
	
	
	
</style>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			//폼 유효성 검사 후 폼을 submit
			$('.btn').click(function(){
				if($('#addEmployeeId').val().length < 4) {
					$('#helper').text("아이디 4자이상입력하시오");
				}else if($('#addEmployeePw').val().length < 4) {
					$('#helper').text("비밀번호 4자이상입력하시오");
				}else if($('#addEmployeePw') != $('#addEmployeePwCheck')) {
					$('#helper').text("비밀번호가 맞지 않습니다.");
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
				<div class="panel-body form-horizontal" >
					<div class="form-group">
						<label class="col-sm-3 control-label for=id">employee_id : </label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="addEmployeeId" name="addEmployeeId">
						</div>
						
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label for=pw">employee_pw : </label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="addEmployeePw" name="addEmployeePw">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label for=pwCheck">employee_pw확인 : </label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="addEmployeePwCheck" name="addEmployeePwCheck">
						</div>
					</div>
					<span id="helper" class="helper"></span>	
					<button type="button" class="btn btn-primary btn-block">직원 입력</button>
				</div>
					
			</div>
				

		<div class="col-sm-3"></div>
			
		</div>
	</div>
</div>
</body>
</html>