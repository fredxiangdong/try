<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>CheckBox Selection on DataGrid - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="/another/plugin/jquery-easyui-1.3.4/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="/another/plugin/jquery-easyui-1.3.4/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="/another/plugin/jquery-easyui-1.3.4/demo/demo.css">
	<script type="text/javascript" src="/another/plugin/jquery-easyui-1.3.4/jquery.min.js"></script>
	<script type="text/javascript" src="/another/plugin/jquery-easyui-1.3.4/jquery.easyui.min.js"></script>
</head>
<body>
	<h2>CheckBox Selection on DataGrid</h2>
	<div class="demo-info">
		<div class="demo-tip icon-tip"></div>
		<div>Click the checkbox on header to select or unselect all selections.</div>
	</div>
	<div style="margin:10px 0;"></div>
	
	<table id="dg" class="easyui-datagrid" title="CheckBox Selection on DataGrid" style="width:700px;height:250px"
			data-options="rownumbers:true,singleSelect:true,url:'datagrid_data1.json',method:'get'">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'itemid',width:80">Item ID</th>
				<th data-options="field:'productid',width:100">Product</th>
				<th data-options="field:'listprice',width:80,align:'right'">List Price</th>
				<th data-options="field:'unitcost',width:80,align:'right'">Unit Cost</th>
				<th data-options="field:'attr1',width:220">Attribute</th>
				<th data-options="field:'status',width:60,align:'center'">Status</th>
			</tr>
		</thead>
	</table>
	<input type ="button" value ="getchecked" onclick = "getchecked()"/>
	<div style="margin:10px 0;">
		<span>Selection Mode: </span>
		<select onchange="$('#dg').datagrid({singleSelect:(this.value==0)})">
			<option value="0">Single Row</option>
			<option value="1">Multiple Rows</option>
		</select><br/>
		SelectOnCheck: <input type="checkbox" checked onchange="$('#dg').datagrid({selectOnCheck:$(this).is(':checked')})"><br/>
		CheckOnSelect: <input type="checkbox" checked onchange="$('#dg').datagrid({checkOnSelect:$(this).is(':checked')})">
	</div>

</body>
<script type ="text/javascript">
	function getchecked(){
		var row = $('#dg').datagrid('getSelected');
		alert(row.itemid);
	}
</script>
</html>