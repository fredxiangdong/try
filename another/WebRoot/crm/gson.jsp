<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>gson测试</title>
	<%@include file ="../../pageset.jspa" %>
  </head>
  
  <body>
  	<input type ="button" value ="测试GSON1" onclick ="testGson()"/>
  	<input type ="button" value ="测试GSON2" onclick ="testGson2()"/>
  	<input type ="button" value ="测试Ajax普通传值" onclick ="testAjaxData()"/>
  	<span>当前登录用户为：</span>
  	<input id ="userName" type ="text" value =" ${session.user.userName}"/>
  	<input type ="button" value ="测试传递汉字" onclick ="sentChFonts()"/>
  	<br>
  	<s:textarea id="strArea" name ="gsonStr" cols ="100" rows ="20" lable ="测试GSON"/>
  	<s:hidden id ="jsondata" name = "gsonStr"></s:hidden>
  </body>
  
  <script type ="text/javascript">
  	function testGson(){
  		$.ajax({
  			method : "post",
  			url : "/another/crm/gsonAction!testGson.do",
  			data : {"gsonStr" : "testsentdata"},
  			dataType : "text",
  			success : function(data){
  				$("#strArea").val(data);
  				dalert("测试GSON完毕！");
  			}
  		});
  	}
  	
  	function testGson2(){
  		$.ajax({
  			method : "post",
  			url : "/another/crm/gsonAction!testGson2.do",
  			dataType : "text",
  			success : function(data){
  				$("#strArea").val(data);
  				$("#jsondata").val(data);
  				dalert("测试GSON完毕！");
  			}
  		});
  	}
  	
  	function testAjaxData(){
  		var url = "/another/crm/gsonAction!testAjaxData.do";
  		params = {
  			"gsonStr" : $("#jsondata").val()
  		};
  		jQuery.post(url,params,calBckFun,"text");
  	}
  	
  	function calBckFun(data){
  		dalert("JSON数据转换成功，对象的userName为："+data);
  	}
  	
  	function sentChFonts(){
		alert($("#userName").val());
		$.ajax({
			method : "post",
// 			data : {
// 				"gsonStr" : $("#userName").val()
// 			},
			dataType :"text",
			/* encodeURI传递中文时需要编码两次*/
			url : encodeURI(encodeURI("/another/crm/gsonAction!testCNfonts.do?gsonStr="+$("#userName").val())),
			success : function(data){
				alert(data);
			} 
		});
  	}
  </script>
</html>
