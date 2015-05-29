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
  
<body align="center">
	<h2>添加楼宇</h2>
	<div class="demo-info">
		<div class="demo-tip icon-tip"></div>
		<div>Fill the form and submit it.</div>
	</div>
	
	<div style="margin:10px 0;"></div>
	
	<div class="easyui-panel" title="New Topic" style="width:400px">
	
		<div style="padding:100px 0 10px 60px">
	    <form id="ff" method="post" action = "/another/crm/jpaBuildingAction!save.do"> 
	    	<table>
	    		<tr>
	    			<td>BuildingName</td>
	    			<td><s:textfield name ="building.buildingName" id="buildingName" upload = "true"></s:textfield></td>
	    		</tr>
	    		<tr>
	    			<td>BuildingCode:</td>
	    			<td><s:textfield name ="building.buildingCode" id ="buildingCode"></s:textfield></td>
	    		</tr>
	    		
	    		<tr>
	    			<td>remark:</td>
	    			<td><s:textfield name ="building.remark" id ="remark"></s:textfield></td>
	    		</tr>
	    			<s:hidden id="buildingId" name = "building.buildingId"/>
	    	</table>
	    </form>
	    </div>
	    
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="subdata()">Submit</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">Clear</a>
	    </div>
	    
	</div>
	
</body>
  <script type ="text/javascript">
	function subdata(){
		var buildingName = encodeURI($('#buildingName').val().trim());
		var buildingCode = encodeURI($('#buildingCode').val().trim());
		var remark = encodeURI($('#remark').val().trim());
		var buildingId = $('#buildingId').val();

 		var building = "{'buildingName' :'"+ buildingName +"','buildingCode':'"
		+buildingCode+"','remark':'"+remark+"','buildingId':'"+buildingId+"'}"; 
/* 		var building = "{\"buildingName\" :\""+ buildingName +"\",\"buildingCode\":\""
		+buildingCode+"\",\"remark\":\""+remark+"\",\"buildingId\":\""+buildingId+"\"}"; */
		alert(building);
 			$.ajax({
				method : "post",
				dataType:"text",
 				data : {buildingStr : building},
				url : "/another/crm/jpaBuildingAction!save.do", 
				success : function(data){
					var result = $.parseJSON(data);
					$("#buildingId").val(result.buildingId);
				}
			}); 
// 			$('#ff').form('submit');  //对象。form.('submit')方式提交中文无乱码，但form方式提交无返回

		}
		
		
		function saveCalBck(){
/* 			alert(data);
			$("#buildingId").val(data); */
			dalert("提交成功");
		}
		
		
		function clearForm(){
			$('#ff').form('clear');
		}
	</script>
</html>
