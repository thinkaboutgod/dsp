<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
	String path = request.getContextPath();
%>
<title>Insert title here</title>
<script type="text/javascript" src=<%=path + "/js/jquery-3.3.1.js"%>></script>
<script type="text/javascript" src=<%=path + "/jsp/client/face.js"%>></script>
</head>
<body>
	<div id="face_box">
		<video  id="video" style="width:400px;height: 400px;margin-left: 500px;"></video>
		<canvas id="canvas" style="display: none;"></canvas>
		<input type="button" id="submit" value="提交" />
		<input type="button" id="cancle" value="取消" onclick="offUserMedia()"/>
	</div>

</body>
</html>