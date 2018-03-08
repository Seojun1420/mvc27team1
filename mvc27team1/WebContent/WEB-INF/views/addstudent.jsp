<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>addstudent</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>	
	<script>
	$(document).ready(function(){
			$("#btn").click(function(){
			if($("#studentId").val().length > 6){
				$("#IdHelper").text("아이디는 6자 이상 ");
				return;
			} else if($("#studentPw ").val().length > 8){
				$("#banHelper").text("패스워드는 8자 이상 입력하세요");
				return;
			} else if($("#studentPwCheck").val().length < 8){
				$("#banHelper").text("확인된 패스워드는 8자 이상 입력하세요");
				return;
			} else if($("#studentPw").val().length < 8){
				$("#banHelper").text("맞지 않습니다.");
				return
			} else {
				 $("#myForm").submit();
			}
		});	
	});
	</script>
	<style>
body {
	background-color: #e3e7ed;
	background-size: cover;
	font-family: 'Open Sans', sans-serif;
	font-weight: 300;
}

#iosBlurBg {
	resize: horizontal;
	position: relative;
	/*width: 100%;
	height: 100vh;*/
	border-top: 450px solid transparent;
	border-left: 550px solid rgba(0,0,0,0.04);
	border-bottom: 450px solid transparent;
	background: linear-gradient(rgba(255, 255, 255, 0.1), rgba(255, 255, 255, 0.1));
	/*box-shadow: 1px 1px 25px #999;*/
}

#whiteBg {
	resize: horizontal;
	position: absolute;
	top: -410px;
	right: 0;
	border-top: 410px solid transparent;
	border-left: 505px solid rgba(255,255,255,1);
	border-bottom: 410px solid transparent;
	border-right: 30px solid transparent;
	background: linear-gradient(rgba(255, 255, 255, 0.1), rgba(255, 255, 255, 1));
}

#bottomEnter{
	position: absolute;
	top: 500px;
	left: 150px;
	z-index: -2;
	border-top: 200px solid transparent;
	border-right: 300px solid #15224a;
	border-bottom: 150px solid transparent;
	transform: rotate(-2deg);
}

#bottomBlurBg{
	position: absolute;
	top: 490px;
	left: 110px;
	z-index: -1;
	border-top: 200px solid transparent;
	border-right: 260px solid rgba(69,138,182,0.4);
	border-bottom: 120px solid transparent;
	transform: rotate(10deg);
}

.enterButton{
	position: absolute;
	top: 660px; 
	left: 330px;
	width: 70px;
	height: 70px;
	text-align: center;
}

.text-white{
	color: #fff;
}

.enterText{
	text-transform: uppercase;
	font-size: 20px;
	font-weight: 300;
	font-family: 'Open Sans', sans-serif;
}

.loginForm{
	position: absolute;
	top: 300px;
	left: 70px;
}

.title{
	 font-weight: 300;
	 font-size: 24px;
	 line-height: 1;
}

.title span{
	font-weight: 800;
	/*letter-spacing: 3px;*/
}

.title hr{
	width: 150px;
	border-width: 2px;
	border-color: #67e2fb; 
	margin: 0;

}

hr.short{
	width: 50px;
	border-width: 2px;
	border-color: #67e2fb; 
	float: left;
	margin: 0;

}


/*= input focus effects css
=========================== */
:focus{outline: none;}

.col-3{float: left; width: 100%; margin-top: 20px; margin-bottom: 0;} 
input{margin-top: 15px;font: 15px/24px "Open Sans", sans-serif; color: #333; width: 100%; box-sizing: border-box; letter-spacing: 1px; width: 65%;}

input::placeholder{
	text-transform: uppercase;
	letter-spacing: 0;
	font-size: 20px;
	font-weight: 300;
	padding-left: 15px;
}

.effect-2{border: 0; padding: 7px 0; border-bottom: 1px solid #ccc;}

.forget button{
	margin-top: 50px;
	border-radius: 0;
	color: #aaa;
	margin-left: 50px;
	font-weight: 700;
}
</style>
</head>
<body>
		<h1 > addstudent </h1>

			<body>

  <div class="container">
	<div class="row">
		<div class="col-md-6 col-sm-6 col-xs-6 col-md-offset-3">
  			<div id="iosBlurBg">
  				<div id="whiteBg"></div>
  			</div>
  			<div id="bottomEnter"></div>
  			<div id="bottomBlurBg"></div>
  			<!-- Login Form -->
  			<div class="loginForm">
  				<div class="title">
  					<p>Student<br><span></span></p>
  					<hr>
  					<hr class="short">
  				</div>
  				<form>
  					<div class="col-3">
			        	<input class="effect-2" type="text" class="studentId" placeholder="아이디...">
			            <span class="focus-border"></span>
			            <span id="IdHelper"></span>

			            <input class="effect-2" type="password" id="studentPw" name="studentPw" placeholder="패스워드...">
			            <span class="focus-border"></span>
			            <span id="banHelper"></span>
			            
			            <input class="effect-2" type="password" id="studentPw" name="studentPw" placeholder="패스워드...">
			            <span class="focus-border"></span>
			            <span id="banHelper"></span>
			        </div>

			        <div class="forget">
			        	<button class="btn btn-default btn-sm">FORGOT PASSWORD?</button>
			        </div>

  				</form>
  			</div>
  			<a href="#">
  				<div class="enterButton">
	  				<i class="fa fa-lock fa-2x text-white"></i><br>
	  				<span class="enterText text-white">Enter</span>
	  			</div>
  			</a>
		</div>
	</div>
</div>
  
	
	

		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
		
</body>
</html>