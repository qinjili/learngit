<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>超市账单管理系统</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link type="text/css" rel="stylesheet" href="statics/css/style.css" />
<script type="text/javascript">
	function logout() {
		top.location = "jsp/login.jsp";
	}
</script>
</head>
<body class="frame-bd">
	<ul class="left-menu">
		<li><a href="jsp/billList.jsp" target="mainFrame">
		<img src="statics/images/btn_bill.gif" />
		</a>
		</li>
		<li><a href="pro/providerList.html" target="mainFrame">
		<img src="statics/images/btn_suppliers.gif" />
		</a>
		</li>
		<li><a href="user/userlist.html" target="mainFrame">
		<img src="statics/images/btn_users.gif" />
		</a>
		</li>	
		<li><a href="jsp/updatePwd.jsp" target="mainFrame">
		<img src="statics/images/btn_password.gif" />
		</a>
		</li>
		<li><a href="#" onClick="logout();">
		<img src="statics/images/btn_exit.gif" />
		</a>
		</li>
	</ul>
</body>
</html>
