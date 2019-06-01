<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页</title>
<%
	String path = request.getContextPath();
%>
<link rel="stylesheet" type="text/css" href=<%=path + "/css/fileinput.min.css"%>>
<link rel="stylesheet" type="text/css" href=<%=path + "/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css"%>>
<link rel="stylesheet" type="text/css" href=<%=path + "/css/main.css"%>>
<link rel="stylesheet" type="text/css" href=<%=path + "/bootstrap-3.3.7-dist/css/bootstrap.min.css"%>>
<link type="text/css" href="<%=path %>/bootstrap-datatable/css/dataTables.bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src=<%=path + "/js/jquery-3.3.1.js"%>></script>
<script type="text/javascript" src=<%=path + "/js/fileinput.js"%>></script>
<script type="text/javascript" src=<%=path + "/bootstrap-3.3.7-dist/js/bootstrap.min.js"%>></script>

<script type="text/javascript" src=<%=path+"/bootstrap-datatable/js/jquery.dataTables.min.js"%>></script>
<script type="text/javascript" src=<%=path+"/bootstrap-datatable/js/dataTables.bootstrap.min.js"%>></script>
<script type="text/javascript" src=<%=path + "/layer/layer.js"%>></script>
<script type="text/javascript" src=<%=path + "/js/zh.js"%>></script>

<script type="text/javascript" src=<%=path + "/js/main_log.js"%>></script>

</head>
<body>
	<div class="container" style="min-width: 600px;">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="row clearfix">
				<div class="col-md-6 column" >
					<h3 class="text-right text-info">
						欢迎来到文档分享平台
					</h3>
				</div>
				<div class="col-md-6 column text-right" style="padding-top: 25px;">
					<label>欢迎您：${user.name }  当前积分：${user.score }</label>
					<button id="infor" class="btn btn-link" type="button">个人信息</button>
					<button id="toupload" class="btn btn-link" type="button">我要上传</button>
					<button class="btn btn-link" type="button">我要下载</button>
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="form-search" >
						<input class="input-medium search-query" type="text" style="width:200px;" /> <button type="submit" class="btn btn-primary">搜索</button>
					</div>
						<table id="filetable" class="table table-bordered table-hover">
							<thead>
								<tr role="row">
									<!-- 													<th >选择</th> -->
									<th>文档标题</th>
									<th>上传人</th>
									<th class='data-formatter="comm_funs.time_format"'>上传时间</th>
									<th>下载积分</th>
									<th>文档类型</th>
									<th>下载次数</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody></tbody>

						</table>
						<!-- 					<table class="table"> -->
<!-- 						<thead> -->
<!-- 							<tr> -->
<!-- 								<th>文档标题</th> -->
<!-- 								<th>上传人</th> -->
<!-- 								<th>上传时间</th> -->
<!-- 								<th>下载积分</th> -->
<!-- 								<th>文档类型</th> -->
<!-- 								<th>下载次数</th> -->
<!-- 							</tr> -->
<!-- 						</thead> -->
<!-- 						<tbody> -->
<%-- 							<s:iterator value="fileList" > --%>
<!-- 								<tr> -->
<%-- 									<td><s:property value="fname"/></td> --%>
<%-- 									<td><s:property value="user.account"/></td> --%>
<%-- 									<td><s:property value="uptime"/></td> --%>
<%-- 									<td><s:property value="dscore"/></td> --%>
<%-- 									<td><s:property value="fileType.tname"/></td> --%>
<%-- 									<td><s:property value="dtimes"/></td> --%>
<!-- 								</tr> -->
<%-- 							</s:iterator> --%>
							
								
<!-- 						</tbody> -->
<!-- 					</table> -->
<!-- 					<ul class="pager"> -->
<!-- 						<li> -->
<!-- 							 <a href="#">上一页</a> -->
<!-- 						</li> -->
<!-- 						<li> -->
<!-- 							 <a href="#">1</a> -->
<!-- 						</li> -->
<!-- 						<li> -->
<!-- 							 <a href="#">2</a> -->
<!-- 						</li> -->
<!-- 						<li> -->
<!-- 							 <a href="#">3</a> -->
<!-- 						</li> -->
<!-- 						<li> -->
<!-- 							 <a href="#">4</a> -->
<!-- 						</li> -->
<!-- 						<li> -->
<!-- 							 <a href="#">5</a> -->
<!-- 						</li> -->
<!-- 						<li> -->
<!-- 							 <a href="#">下一页</a> -->
<!-- 						</li> -->
<!-- 					</ul> -->
				</div>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">个人信息</h4>
            </div>
            <div class="modal-body">
            	<p>用户名：${user.account }</p>
            	<p>性别：男</p>
            	<p>学历：本科</p>
            	<p>职业：程序猿</p>
            	<p>手机号：13359415632</p>	
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary">确认</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>

<div class="modal fade" id="uploadFile" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <form action="toUpload.action" method="post" enctype="multipart/form-data">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">文档上传</h4>
            </div>
            <div class="modal-body ">
            	<ul>
  					<li> <label>文档标题：</label> 
  						<input id="filetitle" type="text" class="form-control">
  					</li>
  					<li> <label>文档简介：</label> 
  						<textarea id="describe" rows="6" cols="30" class="form-control" style="resize: none;"></textarea>
  					</li>
  					<li> <label>请选择上传文档：</label> 
  						<input id="myUpload" type="file" name="file" class="file-loading"  >
  					</li>
  					<li> <label>下载积分：</label> 
  						<input id="score" type="text" class="form-control">
  					</li>
				</ul>

            </div>
            <div class="modal-footer">
            	<input id="submitFile" type="button" class="btn btn-primary"value="提交">
                <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
    </form>
</div>
</body>
</html>