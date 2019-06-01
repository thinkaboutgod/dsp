$(function() {

var table = $("#filetable")
.DataTable({
			"ajax" : "../allFile.action",
			"lengthMenu" : [ 5, 10, 20, 50 ],
			"pagingType" : "full_numbers",
			"searching" : true, // 是否开启搜索+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			"paging" : true,
			"lengthChange" : true,
			"ordering" : true,
			"info" : true,
			"autoWidth" : true,
			"columns" : [
					{
						"data" : "fname"
					},
					{
						"data" : "user.name"
					},
					{
						"data" : "uptime",
						"render" : function(data) {
							return data.substring(0,data.length-2);
						}
					},
					{
						"data" : "dscore"
					},
					{
						"data" : "fileType.tname"
					},
					{
						"data" : "dtimes"
					},
					{
						"data" : "account",
						"orderable" : false, // 禁用排序
						"sDefaultContent" : '',
						"sWidth" : "",
						"render" : function(data, type, full, meta) {
							return data = '<a class="btn btn-primary btn-sm download" href="download.action">下载</a> ';
		
						}
					} ],
		
			"language" : {
				"sProcessing" : "加载中...",
				"sLengthMenu" : "每页显示 _MENU_ 条记录",
				"sZeroRecords" : "没有匹配的结果",
				"sInfo" : "第 _PAGE_ 页 ( 总共 _PAGES_ 页 )",
				"sInfoEmpty" : "显示第 0 至 0 条结果，共 0条",
				"sInfoFiltered" : "(由 _MAX_ 项结果过滤)",
				"sInfoPostFix" : "",
				"sSearch" : "搜索:",
		
				"sUrl" : "",
				"sEmptyTable" : "表中数据为空",
				"sLoadingRecords" : "载入中...",
				"sInfoThousands" : ",",
				"oPaginate" : {
					"sFirst" : "首页",
					"sPrevious" : "上一页",
					"sNext" : "下一页",
					"sLast" : "末页"
				},
			},
		});
	
	
	$("#infor").click(function() {
		$("#myModal").modal("show");
	})

	$("#toupload").click(function() {
		$("#uploadFile").modal("show");
	})

	initFileInput("myUpload", "user/toUpload.action");

	$("#submitFile").click(function() {
		var filetitle = $("#filetitle").val();
		var describe = $("#describe").val();
		var score = $("#score").val();
		
		if ($.trim(filetitle)==""||$.trim(describe)==""||$.trim(score)=="") {
			layer.msg("文件描述不得为空");
			return false;
		};
		alert($("#myUpload"));
		console.log($("#myUpload"));
		if ($("#myUpload").val()=="") {
			layer.msg("请选择文件");
			return false;
		}
		$("#myUpload").fileinput("upload");
	})
	
	$(document).on("click", ".download", function() { 
		//此处拿到选择行的数据中的id 
		var path = table.row($(this).parent().parent()).data().path;  
		var href = $(this).attr("href");
		href = href+"?dpath="+path;
		$(this).attr("href",href);
	})

});
//文件上传
function initFileInput(ctrlName, uploadUrl) {
	var control = $('#' + ctrlName);

	control.fileinput({
		language : 'zh', // 设置语言
		uploadAsync : true,// 默认true异步上传,
		uploadUrl : uploadUrl, // 上传的地址
		allowedFileExtensions : [ 'jpg', 'png', 'gif' ],// 接收的文件后缀
		showUpload : false, // 是否显示上传按钮
		showCaption : true,// 是否显示标题
		browseClass : "btn btn-primary", // 按钮样式
		dropZoneEnabled : false,// 是否显示拖拽区域
		showCancel : false,
		// minImageWidth: 50, //图片的最小宽度
		// minImageHeight: 50,//图片的最小高度
		// maxImageWidth: 50,//图片的最大宽度
		// maxImageHeight: 50,//图片的最大高度
		// maxFileSize: 0,//单位为kb，如果为0表示不限制文件大小
		// minFileCount: 0,
		maxFileCount : 10, // 表示允许同时上传的最大文件个数
		enctype : 'multipart/form-data',
		validateInitialCount : true,
		previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
		msgFilesTooMany : "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
		layoutTemplates : {// 去除缩略图上的上传或者删除按钮
		// actionDelete:'',
			actionUpload:'',
		},
		uploadExtraData : function() {// 向后台传递参数,文件描述
			var data = {
				filetitle : $("#filetitle").val(),
				describe : $("#describe").val(),
				score : $("#score").val()
			};
			return data;
		},
	})
	// 文件异步上传完成之后发生的事件

	$('#' + ctrlName).on("fileuploaded",
			function(event, data, previewId, index) {
		alert(data.response.myresult);
				if (data.response.myresult=="uploadSuccess") {
// layer.msg("上传成功",{time:800});
					
					setTimeout(() => {
						$("#uploadFile").modal("hide");
						$(event.target).fileinput('clear').fileinput('unlock') ;// 清空文件和输入框内容
						clearUpload();
					}, 800);
		            
				}
				
			});
	
	// 同步上传返回结果处理
	$('#' + ctrlName).on("filebatchuploadsuccess",
			function(event, data, previewId, index) {
				alert("同步上传成功");
			});
	
	function clearUpload() {
		 $("#filetitle").val("");
		$("#describe").val("");
		$("#score").val("");
	}
	
	

}

