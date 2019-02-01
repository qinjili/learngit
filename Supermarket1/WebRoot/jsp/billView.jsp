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
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script>
$(function () {
	//跳转修改页面
	$("#update").bind("click",function(){
		var billId=$("#billId").val();
		window.location="BillServlet?id="+billId+"&sign=billUpdate";
	});
	//删除
	$("#del").bind("click",function(){
		var billId=$("#billId").val();
			if(confirm("确认删除？")){
				$.get("BillServlet?sign=del","id="+billId,callback,"json");
			}
			function callback(data){
				if(data.info=="true"){
					alert("删除成功！");
					window.location = "jsp/billList.jsp";
				}else{
					alert("删除失败！");
				}
			}
	});
});
</script>
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">账单管理&gt;&gt;</div>
	</div>
		<div class="content">
			<table class="box">
			  <tbody><tr>
					<td class="field">账单编号：</td>
					<td>${bill.id }<input type="hidden" id="billId" value="${bill.id }"></td>
				</tr>
			   <tr>
					<td class="field">商品名称：</td>
					<td>${bill.productName }</td>
				</tr>
				 <tr>
					<td class="field">商品单位：</td>
					<td>${bill.productUnit }</td>
				</tr>
				<tr>
					<td class="field">商品数量：</td>
					<td>${bill.productCount }</td>
				</tr>
				<tr>
					<td class="field">总额：</td>
					<td>${bill.totalPrice }</td>
				</tr>
			   <tr>
					<td class="field">供应商：</td>
					<td>${bill.providerName }</td>
				</tr>
				 <tr>
					<td class="field">是否付款：</td>
						<td>
							<c:if test="${bill.isPayment==1 }">否</c:if>
							<c:if test="${bill.isPayment==2 }">是</c:if>
						</td>
				</tr>
			</tbody></table>
		</div>
		<div class="buttons">
			<input type="button" name="update" id="update" value="修改" class="input-button">
			<input type="button" name="del" id="del" value="删除" class="input-button">
			<input type="button" name="button" id="button" onclick="history.back(-1)" value="返回" class="input-button"> 
		</div>

</div>



</body></html>