$(function() {
	$("#code").click(function() {
		var address = $("#code").attr("src");
		var time = new Date().getTime();
		$("#code").attr("src", address + "?time=" + time);
	})

	$("#submit").click(function() {
		var ii = layer.load();
		var account = $("#inputaccount").val();
		var pwd = $("#inputPassword").val();
		var code = $("#inputCode").val();
		var data  = {
				"account" : account,
				"pwd" : pwd,
				"code" : code
		}
		data = JSON.stringfy(data);
		$.ajax({
			url : "../user/doLogin.action",
			async : true,
			type : "POST",
			data : data,
			dataType : "text",
			statusCode : {
				404 : function() {
					layer.close(ii);
					layer.msg("页面丢失");
					
				},
				500 : function() {
					layer.close(ii);
					layer.msg("服务器繁忙");;
				}
				
			},
			
			success : function(data) {
				var res = JSON.parse(data);
				if (res != null) {
					if (res.myresult == "loginSuccess") {

						// 此处用setTimeout演示ajax的回调
						setTimeout(function() {
							layer.close(ii);
							window.location.href = "../user/tomain.action";
						}, 500);

					} else if (res.myresult == "codeerror") {
						layer.close(ii);
						layer.msg("验证码错误", {
							time : 800
						});
						setTimeout(() => {
							$("#code").click();
						}, 800);
						

					} else if (res.myresult == "loginFailed") {
						layer.close(ii);
						layer.msg("账号或密码错误", {
							time : 800
						});
						layer.close(ii);
					} else if (res.myresult == "forbidden") {
						layer.msg("账号被锁定，请联系管理员", {
							time : 800
						});

					}
				}

			},
			error : function() {
				layer.close(ii);
				layer.msg("服务器繁忙");

			}
		})
	})
})
