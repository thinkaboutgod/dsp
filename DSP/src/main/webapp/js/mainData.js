$(function() {
	$.extend($.fn.dataTable.defaults, dataTableSeetings);// 公共初始化设置
	datatable_otherSet = {

		"ajax" : "../user_listAllUsers.action",
		// {
		// url :"../user_listAllUsers.action",
		// type :"POST",
		// data:{
		// name:$("#sname").val(),
		// account:$("#saccount").val()
		// }
		// },
		"columns" : [
				// 选择框
				// {
				// "sClass" : "text-center",
				// "data" : "account",
				// "render" : function(data, type, full, meta) {
				// return '<input type="checkbox"
				// class="checkchild" value="'
				// + data + '" />';
				// },
				// "bSortable" : false
				// },
				{
					"data" : "account"
				},
				{
					"data" : "name"
				},
				{
					"data" : "regtime"
				},
				{
					"data" : "education"
				},
				{
					"data" : "job"
				},
				{
					"data" : "phone"
				},
				{
					"data" : "state"
				},
				{
					"data" : "state",
					"orderable" : false, // 禁用排序
					"sDefaultContent" : '',
					"sWidth" : "",
					"render" : function(data, type, full, meta) {

						state = data;
						data = '<button id="deleteBtn" class="btn btn-danger btn-sm" >删 除</button>';
						if (state == '启用') {
							data = data
									+ '<button id="start" class="btn btn-primary btn-sm bt_qi" >禁用</button>';
						} else {
							data = data
									+ '<button id="forbit" class="btn btn-primary btn-sm bt_qi" >启用</button>';
						}

						return data;

					}
				},  ],

		"fnServerParams" : function(aoData) {//设置参数
			aoData._rand = Math.random();
			aoData.push({
				"name" : "name",
				"value" : $("#sname").val()
			}, {
				"name" : "account",
				"value" : $("#saccount").val()
			}, {
				"name" : "begintime",
				"value" : $("#begintime").val()
			}, {
				"name" : "endtime",
				"value" : $("#endtime").val()
			}

			);
		},

	};
	var table = $("#example1").DataTable(datatable_otherSet);//初始化

	// 选择行
	$('#example1 tbody').on('click', 'tr', function() {
		if ($(this).hasClass('selected')) {
			$(this).removeClass('selected');
		} else {
			table.$('tr.selected').removeClass('selected');
			$(this).addClass('selected');
			$(this).addClass('selected');

		}
	});
	// 修改用户信息
	$(document).delegate('#changeBtn', 'click', function() {
		var id = $(this).data("id");
		alert(id);
		$("#changeData").modal('show');
		var rowData = table.rows('.selected').data()[0];// 获取选中行数据
		var inputs = $("#changeData").find('input');

		$("#ed_account").val(rowData.account);
		$("#ed_name").val(rowData.name);
		$("#ed_phone").val(rowData.phone);

	});
	// 删除某一行
	$(document).delegate('#deleteBtn', 'click', function() {
		var node = $(this)
		layer.confirm('是否确认删除该数据？', {
			btn : [ '确定', '取消' ]
		// 按钮
		}, function(index) {
			// node.parent().prev().text("00000");
			table.row('.selected').remove().draw(false);// 删除某一行数据
			layer.close(index);
		}, function() {
		});
		return false;
		// console.log(table.row(index));
		// table.row('.selected').remove().draw( false );//删除某一行数据
		// $("#deleteOneModal").modal('show');
	});
	//自定义搜索
	$("#buttonsearch").on("click", function() {
//		datatable_otherSet.fnServerParams = function(aoData) {
//			aoData._rand = Math.random();
//			aoData.push({
//				"name" : "name",
//				"value" : $("#sname").val()
//			}, {
//				"name" : "account",
//				"value" : $("#saccount").val()
//			}, {
//				"name" : "begintime",
//				"value" : $("#begintime").val()
//			}, {
//				"name" : "endtime",
//				"value" : $("#endtime").val()
//			}
//
//			);
//		}
		// $("#example1" )
		// table.fnClearTable(); // 清空数据
		// table.fnDestroy(); // 销毁datatable
		// table = $("#example1").DataTable(datatable_otherSet);
		// table.fnDestroy(false);
		table.ajax.reload(null, false);// 刷新数据方法,false代表保持当前页
	})
	// 启用禁用方式
	$(document).on("click", ".bt_qi", function() { 
		//此处拿到选择行的数据中的id 
		var id = table.row($(this).parent().parent()).data().cuid;  
		
		var button = $(this);
		var text = $(this).text();
//		var id = table.rows('.selected').data()[0].cuid;
		var state;
		if ("启用" == text) {
			state="start"
		} else if ("禁用" == text) {
			state="forbid"
		};
		$.ajax({
			url : "../user_changeState.action",
			async : true,
			type : "POST",
			data :  {cuid : id,state:state}  ,
			dataType : "text",
			success : function(data) {
				var result = JSON.parse(data);
				if (result.myresult=="changeSuccess") {
					layer.msg("修改成功");
					switch (text) {
					case "启用":
						button.parent().prev().text("启用");
						button.text("禁用");
						break;
					case "禁用":
						button.parent().prev().text("禁用");
						button.text("启用");
						break;
					
					}
				}
			},
			error : function() {
				
				layer.msg("服务器繁忙");

			}
			
		})
	})
})