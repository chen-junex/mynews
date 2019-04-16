<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/global.jsp" %>
<%@ include file="/common/include_common.jsp" %>
<html lang="zh-cn">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>新闻管理</title>
</head>
<body>
<div id="main">
	<div id="toolbar">
		<a class="waves-effect btn btn-info btn-sm" href="javascript:addAction();" ><i class="zmdi zmdi-plus"></i> 新增新闻</a>
		<a class="waves-effect btn btn-warning btn-sm" href="javascript:editAction();" ><i class="zmdi zmdi-edit"></i> 编辑新闻</a>
		<a class="waves-effect btn btn-danger btn-sm" href="javascript:deleteAction();" ><i class="zmdi zmdi-delete"></i> 删除新闻</a>
		<%--<a class="waves-effect btn btn-primary btn-sm" href="javascript:roleAction();" ><i class="zmdi zmdi-male"></i> 用户角色</a>--%>
	</div>
	<table id="table"></table>
</div>

<!-- 用户 -->
<div id="addDialog" class="crudDialog" hidden>
	<div class="container col-md-11" style="margin-top: 10px; margin-left: 55px; display: table;">
		<div class="row" style="margin-top: 10px; margin-bottom: 10px;">
			<div class="col-md-4 text-left"
				style="background-color: #D2E9FF; line-height: 26px; vertical-align: middle;">
				<label style="margin-top: 5px; font-size: 14px; color: grey;">新闻id：</label>
			</div>
			<div class="col-md-7">
				<div class="form-group">
					<input type="text" id="news_id" name="news_id" class="form-control" placeholder="新闻名（必填）" />
				</div>
			</div>
		</div>
		<div class="row" style="margin-top: 10px; margin-bottom: 10px;">
			<div class="col-md-4 text-left"
				style="background-color: #D2E9FF; line-height: 26px; vertical-align: middle;">
				<label style="margin-top: 5px; font-size: 14px; color: grey;">作者姓名：</label>
			</div>
			<div class="col-md-7">
				<div class="form-group">
					<input type="text" id="admin_id" name="admin_id" class="form-control" placeholder="作者姓名（必填）" />
				</div>
			</div>
		</div>
		<div class="row" style="margin-top: 10px; margin-bottom: 10px;">
			<div class="col-md-4 text-left"
				style="background-color: #D2E9FF; line-height: 26px; vertical-align: middle;">
				<label style="margin-top: 5px; font-size: 14px; color: grey;">类目：</label>
			</div>
			<div class="col-md-7">
				<div class="form-group">
					<input type="text" id="class_id" name="class_id" class="form-control" placeholder="密码（必填）" />
				</div>
			</div>
		</div>
		<div class="row" style="margin-top: 10px; margin-bottom: 10px;">
			<div class="col-md-4 text-left"
				style="background-color: #D2E9FF; line-height: 26px; vertical-align: middle;">
				<label style="margin-top: 5px; font-size: 14px; color: grey;">新闻标题：</label>
			</div>
			<div class="col-md-7">
				<div class="form-group">
					<input type="text" id="news_title" name="news_title" class="form-control" placeholder="内容" />
				</div>
			</div>
		</div>
		<div class="row" style="margin-top: 10px; margin-bottom: 10px;">
			<div class="col-md-4 text-left"
				style="background-color: #D2E9FF; line-height: 26px; vertical-align: middle;">
				<label style="margin-top: 5px; font-size: 14px; color: grey;">作者邮箱：</label>
			</div>
			<div class="col-md-7">
				<div class="form-group">
					<input type="text" id="userEmail" name="userEmail" class="form-control" placeholder="邮箱" />
				</div>
			</div>
		</div>
		<div class="row" style="margin-top: 10px; margin-bottom: 10px;">
			<div class="col-md-4 text-left"
				style="background-color: #D2E9FF; line-height: 26px; vertical-align: middle;">
				<label style="margin-top: 5px; font-size: 14px; color: grey;">联系电话：</label>
			</div>
			<div class="col-md-7">
				<div class="form-group">
					<input type="text" id="userPhone" name="userPhone" class="form-control" placeholder="联系电话" />
				</div>
			</div>
		</div>
		<div class="row" style="margin-top: 10px; margin-bottom: 10px;">
			<div class="col-md-4 text-left"
				style="background-color: #D2E9FF; line-height: 26px; vertical-align: middle;">
				<label style="margin-top: 5px; font-size: 14px; color: grey;">发送日期：</label>
			</div>
			<div class="col-md-7">
				<div class="form-group">
					<div class="input-group date form_date">
					<input id="userBirthday" class="form-control" type="text"
						placeholder="请选择日期" readonly> <span
						class="input-group-addon"><span
						class="glyphicon glyphicon-remove"></span></span> <span
						class="input-group-addon"><span
						class="glyphicon glyphicon-calendar"></span></span>
					</div>
					<script type="text/javascript">
						//	日历组件选择
						$(".form_datetime").datetimepicker({
							language : 'zh-CN',
							format : "yyyy-mm-dd hh:ii",
							autoclose : true,
							todayBtn : true,
							minuteStep : 10
						});
						$('.form_date').datetimepicker({
							language : 'zh-CN',
							format : "yyyy-mm-dd",
							todayBtn : true,
							autoclose : true,
							startView : 2,
							minView : 2
						});
					</script>
				</div>
			</div>
		</div>
		<div class="row" style="margin-top: 10px; margin-bottom: 10px;">
			<div class="col-md-4 text-left"
				style="background-color: #D2E9FF; line-height: 26px; vertical-align: middle;">
				<label style="margin-top: 5px; font-size: 14px; color: grey;">照片：</label>
			</div>
			<div class="col-md-7">
				<div class="form-group">
			    	<input id="userPhoto" type="file" style="display:block;"> 
				</div>
			</div>
		</div>
		<div class="row" style="margin-top: 10px; margin-bottom: 10px;">
			<div class="col-md-4 text-left"
				style="background-color: #D2E9FF; line-height: 26px; vertical-align: middle;">
				<label style="margin-top: 5px; font-size: 14px; color: grey;">有效值：</label>
			</div>
			<div class="col-md-7">
				<div class="form-group">
					<select id="userValid" name="userValid" class="selectpicker">
						<option value="true">有效</option>
						<option value="false">无效</option>
					</select>
				</div>
			</div>
		</div>
		
	</div>
</div>

<!-- 角色管理 -->
<div class="modal fade" id="roleModal" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 id="roleModalTitle" class="modal-title">
					用户拥有的角色
				</h4>
			</div>
			<div class="modal-body">
				<div id="roleZtree" class="ztree"></div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default btn-sm" data-dismiss="modal"><i class="zmdi zmdi-close"></i> 关闭</button>
				<button id="roleSave-btn" class="waves-effect btn btn-success btn-sm"
					style="margin-left: 10px; type="button"
					href="javascript:;">
					<i class="zmdi zmdi-save"></i> 保存
				</button>
			</div>
		</div>
	</div>
</div>

</body>

<script type="text/javascript">

var $table = $('#table');
var treeObj;
var userId;
var newsId;
$(function() {
	
	$table.bsTable({
		url: '${pageContext.request.contextPath}/common/news/list',
		idField: 'news_id',// 指定主键列
		singleSelect: false,
		search: true,
		columns: [
			{field: 'state', checkbox: true},
			{field: 'news_id', title: '新闻名', align: 'center'},
			{field: 'admin_id', title: '作者姓名', align: 'center'},
			{field: 'class_id', title: '类目', align: 'center'},
			{field: 'news_title', title: '新闻标题', align: 'center'},
			{field: 'news_img', title: '图片路径', align: 'center'},
			{field: 'news_firsttime', title: '发送时间', align: 'center'},
			{field: 'news_updatetime', title: '修改时间', align: 'center'},
			{field: 'news_click', title: '点击量', align: 'center'},
			{field: 'news_Valid', title: '是否有效', align: 'center', formatter: function(value, row, index){
				if(value){
					return '<span class="label label-info">失效</span>';
				}else {
					return '<span class="label label-danger">正常</span>';
				}
			}}
		]
	});
	
});

// 加载角色 tree 结构
function loadRoleTree(){
	// 角色管理 tree 构建
	var setting = {
		async : {
			enable : true,
			url : "${pageContext.request.contextPath}/common/role/roleCheckedTree",
			autoParam : [ "id", "pid", "name", "level" ],
			otherParam: {"userId" : userId}
		},
		check: {
			enable: true,
			chkStyle: "checkbox",
			chkboxType: { "Y": "s", "N": "s" }
		},
		view : {
			fontCss: setFontCss
		}
	};
	// 初始化 tree 数据
	treeObj = $.fn.zTree.init($('#roleZtree'), setting);
	// 设置样式
	function setFontCss(treeId, treeNode) {
		return treeNode.valid == false ? {color:"red"} : {};
	};
	
	$('#roleModal').modal('show');
}

// 保存角色
$('#roleSave-btn').click(function(){
	var nodes = treeObj.getCheckedNodes(true);
	var roleStr = "";
	$.map(nodes, function(item, index){
		roleStr  += "," + item.id;
	});
	
	$.post('${pageContext.request.contextPath}/common/user/roleSave',{'userId' : userId, 'roleStr' : roleStr.substr(1)},function(data){
		$('#roleModal').modal('hide');
		$.alert(data.msg);
	});
	
});

// 添加
function addAction() {
	$.confirm({
		type: 'blue',
		animationSpeed: 300,
		columnClass: 'col-md-9 col-md-offset-1',
		title: '添加用户',
		content: $('#addDialog').html(),
		buttons: {
			confirm: {
				text: '保存',
				btnClass: 'waves-effect waves-button',
				action: function () {
					// $.alert('保存');
					// $.ajax({
					//
					// })
				}
			},
			cancel: {
				text: '取消',
				btnClass: 'waves-effect waves-button'
			}
		}
	});
}
// 删除
function deleteAction() {
	var rows = $table.bootstrapTable('getSelections');
	if (rows.length == 0) {
		$.confirm({
			title: false,
			content: '请至少选择一条记录！',
			autoClose: 'cancel|3000',
			backgroundDismiss: true,
			buttons: {
				cancel: {
					text: '取消',
					btnClass: 'waves-effect waves-button'
				}
			}
		});
	} else {
		$.confirm({
			type: 'red',
			animationSpeed: 300,
			title: false,
			content: '确认删除该新闻吗？',
			buttons: {
				confirm: {
					text: '确认',
					btnClass: 'waves-effect waves-button',
					action: function () {
                        var ids = new Array();
                        for (var i in rows) {
                            ids.push(rows[i].news_id);
                        }
                        // $.alert('删除：id=' + ids.join("-"));
						var url = '${pageContext.request.contextPath}/common/news/deleteNews';
                        $.ajax({
                            type: "POST",
                            async: false,
                            url: url,
							 data: JSON.stringify(ids),
                            dataType: "json",
							contentType:"application/json",
                            success: function (data) {
                                $.alert('删除：id=' + ids.join("-"));
                            },
                            error: function (e) {
                                alert("错误信息：" + JSON.stringify(e));
                            }
                        });

					}
				},
				cancel: {
					text: '取消',
					btnClass: 'waves-effect waves-button'
				}
			}
		});
	}
}
// 用户角色
function roleAction() {
	var rows = $table.bootstrapTable('getSelections');
	if (rows.length == 0) {
		$.confirm({
			title: false,
			content: '请至少选择一条记录！',
			autoClose: 'cancel|3000',
			backgroundDismiss: true,
			buttons: {
				cancel: {
					text: '取消',
					btnClass: 'waves-effect waves-button'
				}
			}
		});
	} else {
		var row = rows[0];
		if('admin' == row.userType){
    		$.alert('对不起，您不能编辑管理员的角色！');
    	}else{
    		userId = row.userId;
    		$('#roleModalTitle').html('用户[' + row.userName + ']拥有的角色');
    		loadRoleTree();
    	}
	}
}
</script>

</html>