

$(function () {
	$._messengerDefaults = {
			extraClasses: 'messenger-fixed messenger-theme-air messenger-on-top'
		};
	toastr.options = {
			"positionClass": "toast-top-center",
			 "timeOut": "1500", //展现时间
			 "showMethod": "fadeIn",//显示时的动画方式
			 "hideMethod": "fadeOut", //消失时的动画方式
	}
	$("#search").click(function() {
//		$.globalMessenger().post({
//			message:"执行查询",
//			type:"info",
//			hideAfter:2
//		
//		})
//		layer.msg("执行查询");
		toastr.success("执行查询");
	})
});