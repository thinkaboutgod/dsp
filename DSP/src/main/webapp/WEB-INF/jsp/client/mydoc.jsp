<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%String path = request.getContextPath();%>
<link rel="stylesheet" type="text/css" href=<%=path + "/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css"%>>
<%-- <link rel="stylesheet" type="text/css" href=<%=path + "/css/main.css"%>> --%>
<link rel="stylesheet" type="text/css" href=<%=path + "/bootstrap-3.3.7-dist/css/bootstrap.min.css"%>>
<link rel="stylesheet" type="text/css" href=<%=path + "/HubSpot-messenger/build/css/messenger.css"%>>
<link rel="stylesheet" type="text/css" href=<%=path + "/HubSpot-messenger/build/css/messenger-theme-air.css"%>>
<link rel="stylesheet" type="text/css" href=<%=path + "/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css"%>>
<link rel="stylesheet" type="text/css" href=<%=path + "/toastr/build/toastr.min.css"%>>

<script type="text/javascript" src=<%=path + "/js/jquery-3.3.1.js"%>></script>
<script type="text/javascript" src=<%=path + "/bootstrap-3.3.7-dist/js/bootstrap.min.js"%>></script>
<script type="text/javascript" src=<%=path + "/toastr/build/toastr.min.js"%>></script>

<script type="text/javascript" src=<%=path + "/HubSpot-messenger/build/js/messenger.min.js"%>></script>
<script type="text/javascript" src=<%=path + "/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"%>></script>
<script type="text/javascript" src=<%=path + "/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.fr.js"%>></script>
<script type="text/javascript" src=<%=path + "/js/mydoc.js"%>></script>
<script type="text/javascript" src=<%=path + "/layer/layer.js"%>></script>
</head>
<body>
	<div class="container">
	<div class="row clearfix">
		<div class="col-md-10 col-md-offset-1 column">
			<h3 class="text-center text-info">
				我的文档
			</h3>
			<div class="row clearfix">
				<div class="col-md-10 " >
					<label>上传日期：</label>
					<input type='date' id="begintime" style="width: 150px;"/>&nbsp;至&nbsp;
					<input type='date' id="endtime" style="width: 150px;" /><br>
<!-- 					<div class="col-md-6 " > -->
<!-- 					<div class="input-group  date form_date" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd"> -->
<!--                     	<input size="16" type="text" class="form-control" value="" readonly> -->
<!--                    	 	<span class="add-on"><i class="icon-remove"></i></span> -->
<!-- 						<span class="add-on"><i class="icon-th"></i></span> -->
<!--                		 </div> -->
<!--            		    </div> -->
<!--            		    <div class="col-md-6 "> -->
<!--            		    <div class='input-group date form_date'style="width: 300px;" id='datetimepicker2'> -->
<!-- 						 <span class="input-group-addon">至</span> -->
<!--                 		<input type='text' class="form-control" /> -->
<!--                 		<span class="add-on"><i class="icon-remove"></i></span> -->
<!--                 		<span class="input-group-addon"> -->
<!--                    		 <span class="glyphicon glyphicon-calendar"></span> -->
<!--              		   </span> -->
<!--            		    </div> -->
<!--            		    </div> -->
           		    	<label>文档类型：</label>
						<select>
							<option value="">doc</option>
							<option value="">xml</option>
						</select>
						<label>审核类型：</label>
						<select>
							<option value="">请选择</option>
							<option value="">未审核</option>
							<option value="">审核通过</option>
							<option value="">审核不通过</option>
						</select>
						<button type="button" id="search" class="btn y">搜索</button>
					</div>
			</div>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>
							编号
						</th>
						<th>
							产品
						</th>
						<th>
							交付时间
						</th>
						<th>
							状态
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							1
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							Default
						</td>
					</tr>
					<tr class="success">
						<td>
							1
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							Approved
						</td>
					</tr>
					<tr class="error">
						<td>
							2
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							02/04/2012
						</td>
						<td>
							Declined
						</td>
					</tr>
					<tr class="warning">
						<td>
							3
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							03/04/2012
						</td>
						<td>
							Pending
						</td>
					</tr>
					<tr class="info">
						<td>
							4
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							04/04/2012
						</td>
						<td>
							Call in to confirm
						</td>
					</tr>
				</tbody>
			</table>
			<ul class="pager">
						<li>
							 <a href="#">上一页</a>
						</li>
						<li>
							 <a href="#">1</a>
						</li>
						<li>
							 <a href="#">2</a>
						</li>
						<li>
							 <a href="#">3</a>
						</li>
						<li>
							 <a href="#">4</a>
						</li>
						<li>
							 <a href="#">5</a>
						</li>
						<li>
							 <a href="#">下一页</a>
						</li>
					</ul>
		</div>
	</div>
</div>
</body>
</html>