<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="statics/css/style.css">
<script type="text/javascript" src="statics/js/jquery-1.8.3.min.js"></script>
</head>
<body>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">用户管理&gt;&gt;</div>
		</div>
			<div class="content">
				<table class="box"> 
					<tbody>
					<tr>
						<td class="field">用户编号：</td>
						<td>${user.id }<input type="hidden" id="userId" value="${user.id }"></td>
						
					</tr>
					<tr>
						<td class="field">用户名：</td>
						<td>${user.userName }</td>
					</tr>
					<tr>
						<td class="field">用户账号：</td>
						<td>${user.userCode }</td>
					</tr>

					<tr>
						<td class="field">用户性别：</td>
						<td>
								<c:if test="${user.gender==1 }">女</c:if>
								<c:if test="${user.gender==2 }">男</c:if>
							
						</td>
					</tr>
					<tr>
						<td class="field">出生日期：</td>
						<td>${user.birthday }
						</td>
					</tr>
					<tr>
						<td class="field">用户年龄：</td>
						<td>
							${user.age }
						</td>
					</tr>
					<tr>
						<td class="field">用户电话：</td>
						<td>
							${user.phone }
						</td>

					</tr>
					<tr>
						<td class="field">用户地址：</td>
						<td>
							${user.address }
						</td>
					</tr>
					<tr>
						<td class="field">用户权限：</td>

						<td>
							<c:if test="${user.userRole==1 }">系统管理员</c:if>
							<c:if test="${user.userRole==2 }">经理</c:if>
							<c:if test="${user.userRole==3 }">普通用户</c:if>
						</td>
					</tr>
				</tbody></table>
			</div>
			<div class="buttons">
				<input type="button" id="update" value="修改" class="input-button">
				<input type="button" id="del" value="删除" class="input-button"> 
				<input type="button" id="repassword" value="重置密码" class="input-button"> 
				<input type="button" id="backButton" onclick="history.back(-1)" value="返回" class="input-button">
			</div>
	</div>
	<script type="text/javascript" src="statics/js/user/view.js"></script>


</body></html>