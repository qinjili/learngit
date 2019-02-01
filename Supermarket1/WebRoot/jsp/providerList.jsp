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
<title>超市账单管理系统-供应商管理</title>
<link type="text/css" rel="stylesheet" href="statics/css/style.css">
</head>
<body>

	<div class="menu">

		<table>
			<tbody>
				<tr>
					<td><form method="post" action="pro/providerList.html">
							<input name="method" value="query" class="input-text" type="hidden"> 供应商名称：<input name="proName" class="input-text" type="text" value="">&nbsp;&nbsp;&nbsp;&nbsp;
							<input value="查 询" type="submit">
						</form>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="main">

		<div class="optitle clearfix">
			<em><input value="添加供应商" class="input-button" onclick="window.location='pro/providerAdd.html'" type="button">
			</em>
			<div class="title">供应商管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<tbody>
					<tr>
						<td width="70" height="29"><div class="STYLE1" align="center">编号</div>
						</td>
						<td width="80"><div class="STYLE1" align="center">供应商名称</div>
						</td>
						<td width="80"><div class="STYLE1" align="center">联系人</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">联系电话</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">传真</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">操作时间</div>
						</td>
					</tr>
					<c:forEach items="${proList }" var="list">
					<tr>
						<td height="23"><span class="STYLE1">${list.id }</span>
						</td>
						<td><span class="STYLE1"><a href="providerView.html" style="color:red"> ${list.proName }</a>
						</span>
						</td>
						<td><span class="STYLE1"> ${list.proContact }</span>
						</td>
						<td><span class="STYLE1">${list.proPhone }</span>
						</td>
						<td><span class="STYLE1">${list.proFax }</span>
						</td>
						<td><span class="STYLE1">${list.creationDate }</span>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body></html>