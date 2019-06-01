$(function() {
	searchUser();
//	alert(111);
//	function mysuccess(data) {
//		alert("进入success方法");
//		var result = JSON.parse(data);
//		tbody = "<tr><th>用户名</th><th>注册时间</th><th>积分</th><th>上传文档数</th><th>下载文档数</th><th>用户状态</th>";
//		for (var i = 0; i < result.list.length; i++) {
//			var trs = "";
//			trs+='<tr ><td >'+ result.list[i].name
//	        + '</td><td >' + result.list[i].regtime
//	        + '</td><td >' + result.list[i].score
//	        + '</td><td>' + ""
//	        + '</td><td>' + result.list[i].dnum
//	        + '</td><td>' + result.list[i].state
//	        +'</td></tr>';
//			tbody += trs;
//		}
//		$("#maintable").html(tbody);
//	}
//	function myAjax(url,async,type,data,dataType,mysuccess){
//		alert("进入方法");
//		$.ajax({
//			url : url,
//			async : true,
//			type : type,
//			data : data,
//			dataType : dataType,
//			statusCode:{
//				404:function(){
//					layer.msg("页面丢失");
//				},
//				500:function(){
//					layer.mag("");
//				}
//			},
//			success:function(data){
//				mysuccess(data);
//			},
//			error:function(){
//				
//			}
//		})
//	};
//	
//	myAjax("../../user_searchUser.action",true,"POST",{page : 1},"text");
})

function searchUser() {
	$.ajax({
				url : "../../user_searchUser.action",
				async : true,
				type : "POST",
				data : {page : 1},
				dateType : "text",
				success : function(data) {
					alert(data);
					var result = JSON.parse(data);
//					tbody = "<tr><th>用户名</th><th>注册时间</th><th>积分</th><th>上传文档数</th><th>下载文档数</th><th>用户状态</th>";
					tbody ="";
					for (var i = 0; i < result.list.length; i++) {
						var trs = "";
						trs+='<tr ><td >'+ result.list[i].name
                        + '</td><td >' + result.list[i].regtime
                        + '</td><td >' + result.list[i].score
                        + '</td><td>' + ""
                        + '</td><td>' + result.list[i].dnum
                        + '</td><td>' + result.list[i].state
                        +'</td></tr>';
						tbody += trs;
					}
//					$("#maintable").html(tbody);
					$("#maintable").append(tbody);
					var currentPage = result.pageIndex;
					var totalPages = result.totalPage;
					var options = {
						bootstrapMajorVersion : 3,
						currentPage : currentPage,
						totalPages : totalPages,
						numberOfPages : 3,
						itemContainerClass: function (type, page, current) {
				            return (page === current) ? "active" : "";
				        },
						alignment:"center",
						// shouldShowPage : true,
						itemTexts : function(type, page, current) {
							switch (type) {
							case "first":

								return "首页";
							case "prev":

								return "上一页";
							case "next":

								return "下一页";
							case "last":

								return "末页";
							case "page":

								return page;

							}
						},
						//给每个按钮挂载监听
				        onPageClicked: function (event, originalEvent, type, page) {
						
					        $.ajax({
					            async: true,
					            url: "../../user_searchUser.action",
					            type: "POST",
					            dataType : "text",
					            data: {page:page},
					            success: function (data) {
					            	alert(data);
					                var result = JSON.parse(data);
					                result = JSON.parse(result);
					                
//					                tbody="<tr><th>用户名</th><th>注册时间</th><th>积分</th><th>上传文档数</th><th>下载文档数</th><th>用户状态</th>";
					                tbody ="";
									for (var i = 0; i < result.list.length; i++) {
										var trs = "";
										trs+='<tr ><td >'+ result.list[i].name
				                        + '</td><td >' + result.list[i].regtime
				                        + '</td><td >' + result.list[i].score
				                        + '</td><td>' + ""
				                        + '</td><td>' + result.list[i].dnum
				                        + '</td><td>' + result.list[i].state
				                        +'</td></tr>';
										tbody += trs;
									}
					                $("#userTable").html(tbody);

					            }/* success */
					        });

					    }
					}
					
					$('#useroption').bootstrapPaginator(options);
				},

			});
			
};



function success(data) {
	var result = JSON.parse(data);
	tbody = "<tr><th>用户名</th><th>注册时间</th><th>积分</th><th>上传文档数</th><th>下载文档数</th><th>用户状态</th>";
	for (var i = 0; i < result.list.length; i++) {
		var trs = "";
		trs+='<tr ><td >'+ result.list[i].name
        + '</td><td >' + result.list[i].regtime
        + '</td><td >' + result.list[i].score
        + '</td><td>' + ""
        + '</td><td>' + result.list[i].dnum
        + '</td><td>' + result.list[i].state
        +'</td></tr>';
		tbody += trs;
	}
	$("#maintable").html(tbody);
}

