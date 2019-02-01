$(function () {
	//跳转修改页面
	$("#update").bind("click",function(){
		alert("888888");
		var billId=$("#billId").val();
		window.location="jsp/billUpdate.jsp?billId="+billId;
	});
	//删除
	$("#del").bind("click",function(){
		var billId=$("#billId").val();
			if(confirm("确认删除？")){

			}
	});
});
