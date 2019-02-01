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
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>超市账单管理系统-用户管理</title>
<link type="text/css" rel="stylesheet" href="statics/css/style.css">
</head>
<body>
	<div class="menu">

		<table>
			<tbody>
				<tr>
					<td><form method="post" action="user/userlist.html">
							<input name="method" value="query" class="input-text" type="hidden"> 用户名：<input name="name" class="input-text" type="text" value="">&nbsp;&nbsp;&nbsp;&nbsp;
							<input value="查 询" type="submit">
						</form>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="main">

		<div class="optitle clearfix">
			<em><input value="添加用户" class="input-button" onclick="window.location='user/useradd.html'" type="button">
			</em>
			<div class="title">用户管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<tbody>
					<tr>
						<td width="70" height="29"><div class="STYLE1" align="center">编号</div>
						</td>
						<td width="80"><div class="STYLE1" align="center">用户名</div>
						</td>
						<td width="80"><div class="STYLE1" align="center">用户账号</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">性别</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">年龄</div>
						</td>
						<td width="150"><div class="STYLE1" align="center">电话</div>
						</td>
						<td width="150"><div class="STYLE1" align="center">权限</div>
						</td>
					</tr>
					<c:forEach items="${userList }" var="list">
						<tr>
						<td height="23"><span class="STYLE1">${list.id }</span>
						</td>
						<td><span class="STYLE1"> ${list.userName } </span>
						</td>
						<td><span class="STYLE1"><a href="user/userView.html?method=getInfo&amp;userId=${list.id }"> ${list.userCode }</a>
						</span>
						</td>

						<td><span class="STYLE1">
						
							<c:if test="${list.gender==1 }">女</c:if>
							<c:if test="${list.gender==2 }">男</c:if>
						
						 </span>
						</td>
						<td><span class="STYLE1">${list.age } </span>
						</td>
						<td><span class="STYLE1">${list.phone }</span>
						</td>
						<td><span class="STYLE1">
						<c:if test="${list.userRole==1 }">系统管理员</c:if>
						<c:if test="${list.userRole==2 }">经理</c:if>
						<c:if test="${list.userRole==3 }">普通员工</c:if>
							
						
					     </span>
						</td>
					</tr>
						
					</c:forEach>
					
					
					
				</tbody>
			</table>
		</div>
	</div>

</body></html>