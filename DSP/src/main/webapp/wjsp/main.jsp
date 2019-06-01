<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>平台主页</title>
</head>
<%
	String path = request.getContextPath();
%>
<link rel="stylesheet" type="text/css" href=<%=path + "/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css"%>>
<link rel="stylesheet" type="text/css" href=<%=path + "/css/main.css"%>>
<link rel="stylesheet" type="text/css" href=<%=path + "/bootstrap-3.3.7-dist/css/bootstrap.min.css"%>>
<script type="text/javascript" src=<%=path + "/js/jquery-3.3.1.js"%>></script>
<script type="text/javascript" src=<%=path + "/bootstrap-3.3.7-dist/js/bootstrap.min.js"%>></script>
<body>
	<div class="container-fluid">
	<div class="row clearfix">
		<div class="col-md-10" >
			<h3 class="text-center text-info">
				欢迎来到文档分享平台
			</h3>
		</div>
		<div class="col-md-2 " 	>
			 <a href=<%=path+"/user/toLogin.action" %> class="btn btn-link" >登录</a>
			
			 <a class="btn btn-link" type="button">注册</a>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-6 col-md-offset-3">
			<div class="form-search" >
				<input class="input-medium search-query" type="text" style="width:200px;" /> <button type="submit" class="btn btn-primary">搜索</button>
			</div>
		</div>
	</div>
</div>
</body>
</html>