<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>My JSP 'artdialogtest.jsp' starting page</title>
    
	<%@include file = "../../pageset.jspa" %>
  </head>
  
  <body>
  	<span style="padding-left:10px; font-size: 16px; ">点击下面按钮对Artdialog进行测试</span>
  	<br>
 	<br>
	<input type ="button" value = "Button1" onclick = "testBtn1()"/>
	<input type ="button" value = "Button2" onclick = "testBtn2()"/>
	<input type ="button" value = "Button3" onclick = "testBtn3()"/>
  </body>
  
  <script type="text/javascript">
  	function testBtn1(){
	  	var dialog = art.dialog({
		    title: '欢迎',
		    content: '欢迎使用artDialog对话框组件！',
		    icon: 'succeed',
		    follow: document.getElementById('btn2'),
		    ok: function(){
		        return false;
		    },okVal: '确定',
		      cancelVal: '关闭',
		    cancel: function(){
		   	console.log(123);
		    },fixed:true,
		    resize:true
		});
  	}
  	
  	function testBtn2(){
  		art.dialog({ width: '100%', height: '100%', left: '0%', top: '0%',
  		 fixed: true, resize: true, drag: true });
  	}
  	
  		  	
  	function testBtn3(){
  		var  callbackFun = null;
 		dalert("测试ArtDialog!",callbackFun);
  	}
  </script>
</html>
