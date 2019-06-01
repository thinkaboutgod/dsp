$(function() {
	
	$("#register").click(function() {
//		var ii = layer.load();
		
		$.ajax({
			url : "../user/register.action",
			async : true,
			type : "POST",
			data : {
				
			},
			dataType : "text",
			success : function(data) {
//				layer.close(ii);
				window.location.href="clogin.jsp";
			},
			error : function() {
//				layer.close(ii);
				alert("错误页面");
			}
		})
	})
})