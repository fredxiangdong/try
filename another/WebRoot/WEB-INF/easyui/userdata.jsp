<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>用户管理</title>
  	<%@ include file = "../../pageset.jspa" %>

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
	   
 	</div>
	
  </body>
  
  <script type="text/javascript">
	  $(function(){
		$("#tt").datagrid({
			height:$("#body").height()-$('#search_area').height()-5,
			width:$("#body").width(),
			idField:'userId',
			//data: data,
 			url:"../plugin/easyui/datagrid.json",  //可以填入静态JSON数据
// 			url:"/another/crm/gsonAction!testGson.do", //但不可以用这种动态请求
			singleSelect:true, 
			nowrap:true,
			fitColumns:true,
			rownumbers:true,
			showPageList:false,
			columns:[[
				{field:'userName',title:'用户名',width:100,halign:"center", align:"left"},
				{field:'name',title:'姓名',width:100,halign:"center", align:"left"},
				{field:'sex',title:'性别',width:60,halign:"center", align:"left"},
				{field:'department',title:'部门',width:100,halign:"center", align:"left"}
			]], 
			toolbar:'#tt_btn',  
	        pagination:true,
			onDblClickRow:function(rowIndex, rowData){
				viewDetail(rowData.userId);
			}
		});
		
		//新增弹出框
		$("#save").on("click", function(){
			$parent("#parent_win").window({
				width:274,
				height:225,
				href:'user/addUser.html',
				title:'新增用户'
			});
		});
		
		//修改
		$("#update").on("click", function(){
			$parent.messager.alert("提示","update", "info");
		});
		
		//删除
		$("#delete").on("click", function(){
			$parent.messager.alert("提示","delete", "info");
		});
	});
	
	function viewDetail(date, id){
		yalert("查看详细");
// 		$parent.messager.alert("提示","查询详细", "info");
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
		$.ajax({
			method : "post",
			url : "/another/crm/gsonAction!testGson.do", 
			dataType : "text",
			success : function(data){
				var result = $.parseJSON(data);
			    var datasource = { total: result.total, rows: result.rows };
			    $("#tt").datagrid('loadData', datasource);
			 }
		});
	}
	
	function reset(){
		$(".searchCondition").val("");
	}
  </script>
</html>
