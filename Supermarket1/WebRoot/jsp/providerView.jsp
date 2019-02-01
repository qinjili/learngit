<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
			<div class="title">供应商管理&gt;&gt;</div>
		</div>
			<div class="content">
				<table class="box"> 
					<tbody><tr>
						<td class="field">供应商编号：</td>
						<td>5<input type="hidden" id="proId" value="5"></td>
						
					</tr>
					<tr>
						<td class="field">供应商名称：</td>
						<td>北京市粮油总公司</td>
					</tr>
					 <tr>
					<td class="field">联系人：</td>
					<td>黄上清</td>
				</tr>
				<tr>
					<td class="field">联系电话：</td>
					<td>18900000000</td>

				</tr>
				<tr>
					<td class="field">联系地址：</td>
					<td>中关村大厦502</td>
				</tr>
			   <tr>
					<td class="field">传真：</td>
					<td></td>

				</tr>
				 <tr>
					<td class="field">描述：</td>
					<td></td>

				</tr>
				</tbody></table>
			</div>
			<div class="buttons">
				<input type="button" id="update" value="修改" class="input-button" >
				<input type="button" id="del" value="删除" class="input-button"> 
				<input type="button" id="backButton" onclick="history.back(-1)" value="返回" class="input-button">
			</div>
	</div>
	<script type="text/javascript" src="js/provider/view.js"></script>


</body></html>