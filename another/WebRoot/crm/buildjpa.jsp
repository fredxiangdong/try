<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>楼宇管理</title>
  		<!--引入struts标签库-->
	<%@taglib prefix="s" uri="/struts-tags"%>

	<!--引入jquery-->
	<script type="text/javascript" src="/another/plugin/easyui/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="/another/plugin/artDialog/artDialog.js?skin=blue"></script>
	<script type="text/javascript" src="/another/commonUtil.js"></script>
	<script type="text/javascript" src="/another/plugin/jquery-easyui-1.3.4/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/another/plugin/jquery-easyui-1.3.4/locale/easyui-lang-zh_CN.js"></script>
    <link rel ="stylesheet" type ="text/css" href="/another/plugin/jquery-easyui-1.3.4/themes/icon.css">
    <link rel ="stylesheet" type ="text/css" href="/another/plugin/jquery-easyui-1.3.4/themes/metro/easyui.css">

	<script type="text/javascript" src="/another/commonUtil.js"></script> 

  </head>
  
  <body class="easyui-layout" >
    <div id="body" region="center" > 
 	 <!-- 查询条件区域 -->
	  <div id="search_area" >
	    <div id="conditon">
	      <table border="0">
	        <tr>
		      <td>&nbsp;性别：</td>
	          <td><input  name="sex" id="sex"  class = "searchCondition" />
	          <td>&nbsp;部门：</td>
	          <td><input  name="department" id="department"   class = "searchCondition"/></td>
	          <td>用户名：</td>
	          <td ><input  name="userName" id="userName"    class = "searchCondition"/></td>
	          <td>
	              <a  href="javascript:void(0)" class="easyui-linkbutton my-search-button" iconCls="icon-search" plain="true" onclick="retrive()">查询</a> 
	              <a  href="javascript:void(0)" class="easyui-linkbutton my-search-button" iconCls="icon-reset" plain="true" onclick = "reset()">重置</a>
	          </td>
	        </tr>
	      </table>
	    </div>
	    <span id="openOrClose"></span> 
	  </div>
	  <!-- 数据表格区域 -->
	  <table id="tt" style="table-layout:fixed;" ></table>
	  <!-- 表格顶部工具按钮 -->
	  <div id="tt_btn">
	      <a href="javascript:void(0)"  id="save" class="easyui-linkbutton" iconCls="icon-add" plain="true">新增</a>
	      <a href="javascript:void(0)"  id="update" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a> 
	      <a href="javascript:void(0)"  id="delete" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
	   </div>
	   
	    <div id="dd" class="easyui-window" title="Modal Window" data-options="modal:true,closed:true,iconCls:'icon-search'" 
  	     style="width:600px;height:500px;padding:0px;">
  	     <iframe id="frametest" width='99%' height='99%' src=''></iframe>
	   </div>
	   
 	</div>
	
  </body>
  
  <script type="text/javascript">
	  $(function(){
		$("#tt").datagrid({
			height:$("#body").height()-$('#search_area').height()-5,
			width:$("#body").width(),
			idField:'buildingId',
			//data: data,
//  			url:"../plugin/easyui/datagrid.json",  //可以填入静态JSON数据
// 			url:"/another/crm/gsonAction!testGson.do", //但不可以用这种动态请求
			singleSelect:true, 
			nowrap:true,
			fitColumns:true,
			rownumbers:true,
			showPageList:false,
			checkbox:true,
			columns:[[
				{field:'ck',checkbox:'true'},
				{field:'buildingName',title:'buildingName',width:100,halign:"center", align:"left"},
				{field:'buildingCode',title:'buildingCode',width:100,halign:"center", align:"left"},
				{field:'createdStamp',title:'createdStamp',width:60,halign:"center", align:"left"},
				{field:'createdByUserLogin',title:'createdByUserLogin',width:100,halign:"center", align:"left"},
				{field:'lastUpdatedStamp',title:'lastUpdatedStamp',width:60,halign:"center", align:"left"},
				{field:'lastModifiedByUserLogin',title:'lastModifiedByUserLogin',width:100,halign:"center", align:"left"}
			]], 
			toolbar:'#tt_btn',  
	        pagination:true,
			onDblClickRow:function(rowIndex, rowData){
				viewDetail(rowData.buildingId);
			}
		});
		
		//新增弹出框
		$("#save").on("click", function(){
			$('#frametest').attr('src','/another/crm/jpaBuildingAction!add.do');
	        $('#dd').window('open');
		});
		
		//修改
		$("#update").on("click", function(){
			var rows = $('#tt').datagrid('getSelected');
			$('#frametest').attr('src',"/another/crm/jpaBuildingAction.do?action=detail&buildingId="+rows.buildingId);
       		$('#dd').window('open');
		});
		
		//删除
		$("#delete").on("click", function(){
			var rows = $('#tt').datagrid('getSelected');
			var dialog = art.dialog({
			    title: '确认',
			    content: '您确认删除么？',
			    icon: 'succeed',
// 			    follow: document.getElementById('btn2'),
			    ok: function(){
				    $.ajax({
						method : "post",
						dataType : "text",
						data : {
							buildingId :rows.buildingId
						},
						url : "/another/crm/jpaBuildingAction!del.do",
						success : function(){
							retrive();
							dalert("删除成功！");
						}
					});
			    },okVal: '确定',
			      cancelVal: '关闭',
			    cancel: function(){
			    },fixed:true,
			    resize:true
			}); 
		});
		
		
	});
	
	function viewDetail(id){
		$('#frametest').attr('src',"/another/crm/jpaBuildingAction.do?action=detail&buildingId="+id);
        $('#dd').window('open');
	}
	
	//监听窗口大小变化
	window.onresize = function(){
		setTimeout(domresize,300);
	};
	
	//改变表格宽高
	function domresize(){
		$('#tt').datagrid('resize',{  
			height:$("#body").height()-$('#search_area').height()-5,
			width:$("#body").width()
		});
	}
	
	function retrive(){
// 			var page = ${"#pageCount"};
// 		alert(pageCount);
		$.ajax({
			method : "post",
			url : "/another/crm/jpaBuildingAction!retrive.do", 
			data : data,
			dataType : "json",
			success : function(data){
// 				var result = $.parseJSON(data);
// 			    var datasource = { total: result.total, rows: result.rows };
			    $("#tt").datagrid('loadData', data);
			 }
		});
	}
	
	function reset(){
		$(".searchCondition").val("");
	}
  </script>
</html>
