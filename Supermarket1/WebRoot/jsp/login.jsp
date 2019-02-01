<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统登录 - 超市账单管理系统</title>
<link type="text/css" rel="stylesheet" href="statics/css/style.css" />
<script type="text/javascript" src="statics/js/jquery-1.8.3.min.js"></script>
 <script>
	$(function(){
		$("#actionForm").submit(function(){
			 var userCode = $("#userCode").val().trim();
			 var password = $("#password").val().trim();
			 if(userCode==null||userCode==""){
				 $("#loginNameSpan").text("用户名不能为空！");
				 return false;
			 }
			 if(password==null||password==""){
				 $("#passwordSpan").text("密码不能为空！");
				 return false;
			 }
			 return true;
		});
	});	
  </script>
</head>
<body class="blue-style">
<div id="login">
	<div class="icon"></div>
	<div class="login-box">
		<form  action="${pageContext.request.contextPath }/user/dologin.html"  name="actionForm" id="actionForm"  method="post" >
			<dl>
				<dt>用户名：</dt>
				<dd><input type="text" class="input-text" name="userCode" id="userCode"/> <span id="loginNameSpan" style="color:red"></span></dd>
				<dt>密　码：</dt>
				<dd><input type="password"  class="input-text" name="password" id="password" /> <span id="passwordSpan" style="color:red">${error }</span></dd>
			</dl>
			<div class="buttons">
				<input type="submit"   value="登录系统" class="input-button"  />
				<input type="reset"  value="重　　填" class="input-button" />
			</div>
		</form>
	</div>
</div>
</body>
</html>
