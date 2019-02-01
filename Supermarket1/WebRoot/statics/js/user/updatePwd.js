
//修改密码
$("#update").bind("click",function(){
	var userId=$("#userId").val();
	var oldPwd=$("#oldPassword").val();
	var newPwd=$("#newPassword").val();
	if(confirm("确认修改密码？")){
		$.get("user.do", {method:"updatePassword",userId:userId,oldPassword:oldPwd,newPassword:newPwd}, function(data){
			alert(data);
		},"text");
	}
});
