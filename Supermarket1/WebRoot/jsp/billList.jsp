<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>超市账单管理系统-账单管理</title>
<link type="text/css" rel="stylesheet" href="css/style.css">

</head>
<body>
	<c:if test="${billList==null }">
		<script type="text/javascript">
			window.location="BillServlet?sign=billList";
		</script>
	</c:if>
	<div class="menu">

		<table>
			<tbody>
				<tr>
					<td><form method="post" action="BillServlet?sign=billList">
							<input name="method" value="query" class="input-text" type="hidden"> 
							商品名称：<input name="productName" class="input-text" type="text" value="">
							供应商名称：<input name="proName" class="input-text" type="text" value="">
							
							是否付款：<input type="radio" name="payed" value="2">是<input type="radio" name="payed" value="1">否
							<input value="查 询" type="submit">
						</form>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="main">

		<div class="optitle clearfix">
			<em><input value="添加账单" class="input-button" onclick="window.location='jsp/billAdd.jsp'" type="button">
			</em>
			<div class="title">账单管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<tbody>
					<tr>
						<td width="70" height="29"><div class="STYLE1" align="center">编号</div>
						</td>
						<td width="80"><div class="STYLE1" align="center">商品名称</div>
						</td>
						<td width="80"><div class="STYLE1" align="center">供应商</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">账单金额</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">是否付款</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">操作时间</div>
						</td>
					</tr>
					
					<c:forEach items="${billList }" var="list">
						<tr>
							<td height="23"><span class="STYLE1">${list.id }</span></td>
							<td><span class="STYLE1"><a
									href="BillServlet?billId=${list.id }&sign=billById"> ${list.productName }</a> </span></td>
							<td><span class="STYLE1"> ${list.providerName }</span></td>
							<td><span class="STYLE1">${list.totalPrice }</span></td>
							<td><span class="STYLE1"> 
									<c:if test="${list.isPayment==1 }">否</c:if> 
									<c:if test="${list.isPayment==2 }">是</c:if> 
								</span></td>
							<td><span class="STYLE1"> <fmt:formatDate value="${list.creationDate }" pattern="yyyy-MM-dd"/> </span></td>
						</tr>
					</c:forEach>
					
					
				</tbody>
			</table>
		</div>
	</div>

</body></html>