var  loginNamePassed=true;

function isExistUser(userCode){
	$.getJSON("user/ucexist.html", {method:"exist",userCode:userCode}, function(data){
		if(data.userCode=="exist"){
			$("#loginName_span").text("用户账号已存在，请更换新账号！");
			loginNamePassed=false;
		}else{
			$("#loginName_span").text("用户账号可以使用！");
		}
	}) ;
}

$("#userCode").bind("blur",function(){
	if($("#userCode").val()){
	   isExistUser($("#userCode").val());
	}
});

$("#add").bind("click",function(){
	//判断是否是数字的正则表达式
	var  passed=true;
	var p1 = "^\\d+$";
	if(!$("#userName").val())
	{
		$("#name_span").text("请输入用户名");
		passed=false;
	}
	if(!$("#userCode").val())
	{
		$("#loginName_span").text("请输入用户账号");
		passed=false;
	}
	if(!$("#userPassword").val())
	{
		$("#password_span").text("请设置账号密码");
		passed=false;
	}else if(!$("#rpassword").val()){
		$("#password_span").text("请填写确认密码");
		passed=false;
	}else if($("#rpassword").val()!=$("#userPassword").val()){
		$("#password_span").text("确认密码不相同");
		passed=false;
	}
	if(!$("#birthday").val())
	{
		$("#birthDate_span").text("请输入出生日期");
		passed=false;
	}else{
		var pattern = /^(\d{4})-(\d{2})-(\d{2})$/;
		if(!pattern.test($("#birthday").val()))
		{
			$("#birthDate_span").text("请输入正确的日期格式，如1988-08-02");
			$("#birthDate").val("");
			passed=false;
		}
	}
	if(!$("#phone").val())
	{
		$("#phone_span").text("请输入电话");
		passed=false;
	}else{
		var pattern = new RegExp(p1);
		if(!pattern.test($("#phone").val()))
		{
			$("#phone_span").text("请输入正确的电话号码");
			$("#phone").val("");
			passed=false;
		}
	}
	
	if(passed&&loginNamePassed){
		if(confirm("确认提交？"))
			$("#form1").submit();
		else
			return false;
		
	}
});
