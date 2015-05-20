<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     
	<title>echart</title>
	<%@taglib prefix="s" uri="/struts-tags"%>

	<!--引入jquery-->
 	<script type="text/javascript" src="/another/plugin/easyui/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="/another/plugin/artDialog/artDialog.js?skin=blue"></script>
	<script type="text/javascript" src="/another/commonUtil.js"></script>
	<script type="text/javascript" src="/another/plugin/jquery-easyui-1.3.4/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/another/plugin/jquery-easyui-1.3.4/locale/easyui-lang-zh_CN.js"></script>
    <link rel ="stylesheet" type ="text/css" href="/another/plugin/jquery-easyui-1.3.4/themes/icon.css">
    <link rel ="stylesheet" type ="text/css" href="/another/plugin/jquery-easyui-1.3.4/themes/metro/easyui.css"> 
 
	
    <link href="/another/plugin/easyui/css/default.css" rel="stylesheet" type="text/css" />
<!--     <link rel="stylesheet" type="text/css" href="/another/plugin/easyui/js/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="/another/plugin/easyui/js/themes/icon.css" />  -->
    <script type="text/javascript" src="/another/plugin/easyui/js/extends.js"></script> 
	<script type="text/javascript" src="/another/commonUtil.js"></script> 
	
  </head>
  
  <body>
  <div style="margin:10px 0;">
<a href="javascript:void(0)" class="easyui-linkbutton" onclick="openbar()">openbar</a>
<a href="javascript:void(0)" class="easyui-linkbutton" onclick="openline()">openline</a>
<a href="javascript:void(0)" class="easyui-linkbutton" onclick="openpie()">openpie</a>
<a href="javascript:void(0)" class="easyui-linkbutton" onclick="openchinamap()">openchinamap</a>
</div>
<div id="dd" class="easyui-window" title="Modal Window" data-options="modal:true,closed:true,iconCls:'icon-search'" 
  	     style="width:800px;height:500px;padding:0px;">
  	     <iframe id="frametest" width='99%' height='99%' src=''></iframe>
	</div> 
  </body>
  
  <script type="text/javascript">
  	
     function openbar() {
       $('#frametest').attr('src','/another/plugin/echarts/demo/bar.html');
       $('#dd').window('open');
     }
     
     function openline() {
       $('#frametest').attr('src','/another/plugin/echarts/demo/line.html');
       $('#dd').window('open');
     }
     
    function openpie() {
       $('#frametest').attr('src','/another/plugin/echarts/demo/pie.html');
       $('#dd').window('open');
     }
     
     function openchinamap() {
       $('#frametest').attr('src','/another/plugin/echarts/demo/chinaMap.html');
       $('#dd').window('open');
     }
     
  </script>
  
</html>
