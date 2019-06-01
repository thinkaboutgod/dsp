<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登录</title>
<%
	String path = application.getContextPath();
%>
<link rel="stylesheet" type="text/css" href=<%=path + "/css/bootstrap-theme.min.css"%>>
<link rel="stylesheet" type="text/css" href=<%=path + "/css/layoutit.css"%>>
<link rel="stylesheet" type="text/css" href=<%=path + "/css/bootstrap.min.css"%>>
<script type="text/javascript" src=<%=path + "/js/jquery-3.3.1.js"%>></script>
<script type="text/javascript" src=<%=path + "/js/bootstrap.min.js"%>></script>
<script type="text/javascript" src=<%=path + "/layer/layer.js"%>></script>
<script type="text/javascript" src=<%=path + "/js/clogin.js" %>></script>
</head>
<body>

		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="row clearfix">
						<div class="col-md-3 column" style="border: none"></div>
						<div class="col-md-6 column">
							<form class="form-horizontal" role="form" action="../../login_doLogin.action" method="post">
								<input type="hidden"  id="type" name="type" value="login"/>
								<div class="form-group">
									<label for="inputEmail3" class="col-sm-3 control-label">账号：</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" id="inputaccount" name="user1.account" value="${user1.account }"/>
									</div>
								</div>
								<div class="form-group">
									<label for="inputPassword3" class="col-sm-3 control-label">密码：</label>
									<div class="col-sm-6">
										<input type="password" class="form-control" id="inputPassword" name="user1.pwd"/>
									</div>
								</div>
								<div class="form-group">
									<label for="inputPassword3" class="col-sm-3 control-label">验证码：</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" name="code" id="inputCode" />
									</div>
									<div class="col-sm-4">
										<img id="code" alt="" src=<%=path+"/user/getCode.action"%> style="border: 1px;">
									</div>
								</div>
								<div class="form-group" >
									<div class="col-sm-offset-4 col-sm-8" >
										<button id="submit" type="button" class="btn btn-default">登录</button>&nbsp;
										<a href=<%=path+"/wjsp/cregister.jsp" %> class="btn btn-default">去注册</a>
									</div>
								</div>
							</form>
						</div>
						<div class="col-md-3 column" style="border: none"></div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>