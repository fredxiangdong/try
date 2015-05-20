<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <%@include file ="../../pageset.jspa"%>
    <title>My JSP 'jasper.jsp' starting page</title>
    

  </head>
  
  <body>
  request.getContextPath(): <%=request.getContextPath() %>  <br>
  request.getScheme():	<%=request.getScheme() %>  <br>
  request.getServerName():	<%=request.getServerName()%>  <br>
  request.getServerPort():	<%=request.getServerPort()%>  <br>
  basePath:	<%=basePath %>  <br><br>
  	<input type ="button" onclick = "jasperTest()" value ="测试Jasper">
    This is my JSP page. <br>
  </body>
  
  <script type ="text/javascript"> 
      function jasperTest(){
      	$.ajax({
      		method : "post",
      		url : "/another/crm/jasperAction!testJasper.do",
      		success : function(response){
      			dalert("jasper测试成功");
      		}
      	});
      }
  </script>
</html>
