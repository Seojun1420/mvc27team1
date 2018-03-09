<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Set" %>
<!DOCTYPE html>
<%@ page import="model.Student" %>
<%@page import="java.util.ArrayList" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<title> GetStudentList </title>
</head>
	<style>
	body{
    background:url(https://www.squiz.net/__public/Systems/Perspective/FileCache/1-32000/465/prop/header-bg-image.jpg?t=1472431690);
    padding:70px;
    
	}
		h1{text-align: center;color: white !important;}
	</style>
<body>
	
	<div class="col-sm-3"></div>
		<div class="col-sm-6"> 
		<h1> GetStudentList </h1>
		<div class="bs-example" data-example-id="contextual-table">
    <table class="table table-striped" >
        <tr>
          <th>회원 번호</th>
          <th>회원 ID</th>
          <th>회원 Password</th>
        </tr>
	<%
		ArrayList<Student> arrayList=(ArrayList<Student>)(request.getAttribute("ArrayList"));
		for(Student arr:arrayList){
	%>
    	 <tr>
          <td><%= arr.getNumber() %></td>
          <td><%= arr.getId() %></td>
          <td><%= arr.getPassword() %></td>
        </tr>
      <%
			}
      %>
    </table>
    </div>
    <div class="col-sm-3"></div>
    
</body>
</html>