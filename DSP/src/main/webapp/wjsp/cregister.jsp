<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"  >
<title>用户注册</title>
<%
	String path = request.getContextPath();
%>
<link rel="stylesheet" type="text/css" href=<%=path + "/css/bootstrap-theme.min.css"%>>

<link rel="stylesheet" type="text/css" href=<%=path + "/css/cregister.css"%>>
<link rel="stylesheet" type="text/css" href=<%=path + "/css/bootstrap.min.css"%>>
<script type="text/javascript" src=<%=path + "/js/jquery-3.3.1.js"%>></script>
<script type="text/javascript" src=<%=path + "/js/bootstrap.min.js"%>></script>
<script type="text/javascript" src=<%=path + "/js/register.js"%>></script>
</head>
<body>
<!-- 	<form action="login_register.action" method="post"> -->
	<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="row-fluid ">
				<div class="span4 ">
				</div>
				<div class="span4 col-sm-offset-4" >
					<div class="reg">
					<h3 class="text-center">
						注册
					</h3><hr>
					<div >
						<input type="hidden"  id="type" name="type" value="register"/>
						<ul class="box box2">
							<li>
    							<label for="account">账号：</label>
    							<input type="text" placeholder="请输入您的账号" id="account" name="user1.account" maxlength="11" />
    							<span class="error"></span>
    						</li>
    						<li>
    							<label for="password2">密码：</label>
    							<input type="password" class="password" id="password2" name="user1.pwd" placeholder="请输入密码" />
    							<span class="error"></span>
    						</li>
    						<li>
    							<label for="password3">确认密码：</label>
    							<input type="password" class="email" id="password3" placeholder="请再次输入密码" />
    							<span class="error"></span>
    						</li>
    						<li>
    							<label for="sex">性别：</label>
    							男<input id="sexc" type="radio" name="user1.sex" value="男" checked = "checked">&nbsp &nbsp &nbsp
               	    			  女<input id="sexc" type="radio" name="user1.sex" value="女">
    						</li>
    						<li>
    							<label for="education">学历：</label>
    							<select id="education" name="education">
    								<option value="无">无</option>
    								<option value="高中">高中</option>
    								<option value="本科">本科</option>
    								<option value="硕士">硕士</option>
    							</select>
    						</li>
    						<li>
    							<label for="job">职业：</label>
    							<select id="job" name="job">
    								<option value="无">无</option>
    								<option value="白领">白领</option>
    								<option value="公务员">公务员</option>
    								<option value="教师">教师</option>
    							</select>
    						</li>
    						<li>
    							<label for="phone">手机号：</label>
    							<input type="text" placeholder="请输入您的手机号" id="phone" name="phone" maxlength="11" />
    							<span class="error"></span>
    						</li>
    						<li>
    							<label for="email">邮箱：</label>
    							<input type="email" placeholder="请输入您的邮箱" id="email" name="email"  />
    							<span class="error"></span>
    						</li>
    					</ul>
    					
					</div>
						<div class="col-sm-offset-4 " >
								<button id="register"  class="btn btn-primary">注册</button>&nbsp;
								<a href=<%=path+"/wjsp/clogin.jsp" %> class="btn btn-primary">去登录</a>
						</div>
						
					</div>
					
				</div>
				<div class="span4">
				</div>
			</div>
		</div>
	</div>
</div>
<!-- </form> -->
</body>
</html>