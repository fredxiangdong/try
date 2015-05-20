<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>My JSP 'poitest.jsp' starting page</title>
    <%@include file ="../../pageset.jspa" %>

  </head>
  
  <body>
    This is my JSP page. <br>
    <s:form id="form1">
    <s:textfield id="excelPath" name="excelPath"  />
    <input type="button" value="读取excel" onclick ="poiexceltest()" >
    <br>
     <s:textfield id="docpath" name="docPath" value="%{docPath}" />
    <input type="button" value="将doc文件转换为excel文件" onclick ="poidoctest()" >
    </s:form>
  </body>
  
  <script type="text/javascript">
  	function poiexceltest(){
     var path =	$("#excelPath").val();
  	 $.ajax({
  	 	method:"post",
  	 	data :{excelPath:path},//貌似这种写法的jQuery不可用params
  	 	url:"/another/crm/poiAction!testPOI.do",
  	 	success:function (response){
  	 		alert("成功！");
  	 	}
  	 });
  	}
  	
  	function poidoctest(){
  		var docPath = $("#docpath").val();
  	      //JQury方式取得数据
		 var url = "/another/crm/poiAction!testDocPOI.do";  
         var params = {  
             docPath:docPath
         };  
         jQuery.post(url, params, callbackFun, 'json'); 
  	}
  	
  	function callbackFun(response){
  		dalert("doc的POI测试成功！");
  	}
  </script>
</html>
