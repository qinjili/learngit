<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<style>
* {
	padding: 0px;
	margin: 0px;
	height: 100%;
	width: 100%;
}

.content {
	padding-top: 100px;
	box-sizing: border-box
}

.top {
	height: 100px;
	width: 100%;
	position: absolute;
	top: 0px;
}

.left {
	float: left;
	width: 20%;
}

.right {
	float: left;
	width: 80%;
}

#top {
	height: 100px;
}
</style>
</head>
<body>
	<div class="content">
		<div class="top">
			<iframe src="jsp/top.jsp" scrolling="No" id="top" noresize="noresize">
			</iframe>
		</div>
		<div class="main">
			<div class="left">
				<iframe src="jsp/left.jsp" scrolling="No" id="left"
					noresize="noresize"> </iframe>
			</div>
			<div class="right">
				<iframe src="jsp/main.jsp" id="mainFrame" name="mainFrame"
					noresize="noresize"> </iframe>
			</div>
		</div>
	</div>

</body>
</html>