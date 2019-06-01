$(function() {
	InitFileInput("myUpload", "../../toUpload.action");
	function InitFileInput(ctrlName, uploadUrl) {
		var control = $('#' + ctrlName); 
		console.log(control);
		$('#' + ctrlName).fileinput({
	        language: 'zh', //设置语言
	        uploadUrl: uploadUrl, //上传的地址
	        allowedFileExtensions : ['jpg', 'png','gif'],//接收的文件后缀
	        showUpload: true, //是否显示上传按钮
	        showUploadedThumbs:false,
	        showCaption: true,//是否显示标题
	        browseClass: "btn btn-primary", //按钮样式             
	        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>", 
	        enctype : 'multipart/form-data',
	        layoutTemplates:{//去除缩略图上的上传或者删除按钮
//				actionDelete:'',
				actionUpload:'',
			}
		});
		//同步上传返回结果处理
		$("#uploadfile").on("filebatchuploadsuccess", function (event, data, previewId, index) {
		      alert("上传成功");
		   });
		//异步上传返回结果处理
		$("#uploadfile").on("fileuploaded", function (event, data, previewId, index) {
			alert("上传成功");
			//	        console.log(data.id);
//	        console.log(data.index);
//	        console.log(data.file);
//	        console.log(data.reader);
//	        console.log(data.files);
//	        var obj = data.response;
//	        alert(JSON.stringify(data.success));
	      });
	}
})

