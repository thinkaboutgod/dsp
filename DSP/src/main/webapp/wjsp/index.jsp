<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src=<%=request.getContextPath()+"/js/jquery-3.3.1.js" %>></script>
</head>
<body>
	<form action="admin/userinfo.action" method="post">
		用户名<input type="text" id="account" name="account"><br>
		密码<input type="password" id="pwd" name="password"><br>
		<input id="submit" type="button" value="提交">
	</form>
	<form action="admin/file.action" method="post" enctype="multipart/form-data">
		请选择文件<input type="file" name="file"><br>
		<input type="submit" value="提交文件">
	</form>
</body>
<script type="text/javascript">
	$(function () {
		$("#submit").click(function() {
			var account=$("#account").val();
			var pwd=$("#pwd").val();
			var data={
					"account" : account,
					"pwd" : pwd,
				}
			$.ajax({
				url : "../test.action",
				async : true,
				type : "POST",
 				contentType : "application/json;charset=utf-8", //如果采用requestbody那么一定要加
				data : 
// 					'{"account" : '+account+',"pwd" : '+pwd+'}',
					
					JSON.stringify(data), 
				success:function(msg){
					alert(msg);
					console.log(msg);
					/* alert(msg[0].username); */
				}
			})
		})
	})
</script>
</html>