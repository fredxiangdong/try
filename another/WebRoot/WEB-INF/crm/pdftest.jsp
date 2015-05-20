<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
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
        
    <title>My JSP 'mypdftest.jsp' starting page</title>
    
  </head>
  
  <body>

<form id="form1">
<h2>Basic Window</h2>
<div class="demo-info">
<div class="demo-tip icon-tip"></div>
<div>Window can be dragged freely on screen.</div>
</div>
<div style="margin:10px 0;">
<a href="javascript:void(0)" class="easyui-linkbutton" onclick="OpenPdf()">OpenPdf</a>
<a href="javascript:void(0)" class="easyui-linkbutton" onclick="DownloadPdf()">DownloadPdf</a>
<a href="javascript:void(0)" class="easyui-linkbutton" onclick="OpenPic()">OpenPic</a>
<a href="javascript:void(0)" class="easyui-linkbutton" onclick="OpenFrame2()">OpenCrmTest</a>
<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#dd').window('close')">Close</a>
</div>
        
  	<div id="dd" class="easyui-window" title="Modal Window" data-options="modal:true,closed:true,iconCls:'icon-search'" 
  	     style="width:800px;height:546px;padding:0px;">
  	     <iframe id="frametest" width='99%' height='99%' src=''></iframe>
	</div>
        <script>
        </script>
    </form>
  </body>
  
  <script type="text/javascript">
  	
     function OpenPdf() {
       $('#frametest').attr('src','/another/crm/testPdfAction!showPdf.do');
       $('#dd').window('open');
     }
     
     function OpenPic() {
       $('#frametest').attr('src','/another/crm/testPdfAction!showPic.do');
       $('#dd').window('open');
     }
     
     function OpenFrame2() {
       $('#frametest').attr('src','/another/crm/buildingAction.do');
       $('#dd').window('open');
     }
       
     function DownloadPdf(){
      	var url = "/another/crm/testPdfAction!downLoadPdf.do";
      	var keys = null;
      	var values = null;
		openWindowWithPost(url, "downLoad", keys, values);
     }     
     
     function callbackFun(){
     	dalert("恭喜你，下载成功！");
     }
  </script>
</html>
