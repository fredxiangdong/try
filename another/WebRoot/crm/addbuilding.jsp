<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>添加楼宇</title>
    <%@include file="../../pageset.jspa" %>
  </head>
  
  <body>
<body>
	<h2>Basic Form</h2>
	<div class="demo-info">
		<div class="demo-tip icon-tip"></div>
		<div>Fill the form and submit it.</div>
	</div>
	<div style="margin:10px 0;"></div>
	<div class="easyui-panel" title="New Topic" style="width:400px">
		<div style="padding:10px 0 10px 60px">
	    <form id="ff" method="post" action = "jpaBuildingAction!save.do">
	    	<table>
	    		<tr>
	    			<td>BuildingName</td>
	    			<td><input class="easyui-validatebox" type="text" name="name" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>BuildingCode:</td>
	    			<td><input class="easyui-validatebox" type="text" name="email" data-options="required:true,validType:'email'"></input></td>
	    		</tr>
	    		
	    		<tr>
	    			<td>remark:</td>
	    			<td><textarea name="message" style="height:60px;"></textarea></td>
	    		</tr>
	    	</table>
	    </form>
	    </div>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">Submit</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">Clear</a>
	    </div>
	</div>
	<script>
		function submitForm(){
			$('#ff').form('submit');
		}
		function clearForm(){
			$('#ff').form('clear');
		}
	</script>
</body>
  </body>
</html>
