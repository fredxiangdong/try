<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<!--引入struts标签库-->
<%@taglib prefix="s" uri="/struts-tags"%>

<!--引入jquery-->
<script type="text/javascript" src="../jquery.js"></script>

<title>Insert title here</title>
</head>
<body>
<s:hidden id="building" value="building" upload="true"/>
<s:textfield value="%{test}" />
<s:textfield value="%{building.buildingId}" title="小区ID"/>
<s:textfield value="%{building.buildingName}" title="小区名称"/>
<!--struts标签配合OGNL方法以setget方式取值-->

<%=request.getAttribute("target") %>
<!--servlet方式取值-->

<!-- EL表达式形式为 ${expression} -->

<!--struts 判断-->
<s:set name="age" value="24"/>
<s:if test="$(age<10)">
	少年
</s:if>
<s:elseif test="$(age>60)">
	老人
</s:elseif>
<s:else>
	壮年
</s:else>


<s:form action="" method="post">
	<s:textfield name="%{test}"/>
	<s:textfield name="%{test}" readonly="true"/>
</s:form>

<s:form name="form1" >
    <s:doubleselect label="请选择所在省市"

       name="province" id="provinceId" list="{'四川省','山东省'}" doubleName="city"

       doubleList="top == '四川省' ? {'成都市', '绵阳市'} : {'济南市', '青岛市'}" />
       
       <input name="button" id="button" onclick="userCheck()" value="button提交" type="button">

</s:form>




<s:form>

    <s:checkboxlist name="interest" list="{'足球','篮球','排球','游泳'}" label="兴趣爱好"/>
    
<s:form id="testform">
	<s:hidden id="buildingLs" name="buildingLs" />
	
	   <s:iterator id="building" value="buildingLs">
	   	<table>
	   		<tr>
	   			<td>小区ID	</td>
	   			<td title="ID"><s:property value="#building.buildingId" /></td>
	   			<td>小区名称	</td>
	   			<td><s:property value="#building.buildingName" />
	   			</td>
	   		</tr>
	   	</table>
    </s:iterator>
        <s:textarea id="output" name="personal" cols="100" rows="5" label="个人简历"></s:textarea>
        <br/>
    <s:select label="最高学历" name="education" list="{'高中','大学','硕士','博士'}"/>
    <s:select label="小区" name="buildId" id="_buildingId"  list="%{buildingLs}" listKey="buildingId" listValue="buildingName"/>
	<br/>
	<input type="button" onclick="submitTest()" value="得到小区ID">
	<input type="button" onclick="submitCollection()" value="得到小区集合">
    <input type="button" onclick="importExcel()" value="导入Excel数据">
    <input type="button" onclick="retriveStock()" value="获取股票数据">
    
</s:form>
</s:form>



</body>
<script type="text/javascript">  
    function userCheck(){  
        var form = document.form1;  
        var province = form.province.value; 
       var pro = document.getElementById("provinceId").value;
       alert(pro);
        alert(province);
        //传统JSP方法取得前台对象
    }  
   
    function submitTest(){
        var buildId = $("#_buildingId").val();  
 		alert(buildId);
		//JQury方式取得数据
		 var url = 'testAjax.do';  
                var params = {  
                    "action" :"testAjax",
                    buildingId:buildId  
                };  
                jQuery.post(url, params, callbackFun, 'json'); 
         }
         
//		$.ajax({
//        type: "GET",
//        url: "buildingAction.do?action=testAjax",
//        data: {
//        
//        },
//        params :{
//        	buildingId : buildId
//        },
//        success: function(response){
//		alert("cc");
//		}
//        var decimal = document.getElementById('decimal'); 
//        $("#decimal").val($("key",xml).text());
//
//        $("#rating").html("按键代码：" + $("key",xml).text());
//        }    

    
    
    function callbackFun(data)  
       {  
           alert(data);
           $("#output").val(data);
       }
    
    
    function submitCollection(){
     var buildingLs = $("#buildingLs").val();  
/*     var list = [];
     list.push(buildingLs) ;*/
 		alert(buildingLs);
		//JQury方式取得数据
		 var url = 'testAjaxCollect.do';  
                var params = {  
                    buildingLs: buildingLs  
                };  
                jQuery.post(url, params, CollectcallbackFun, 'json');
    }
    
        function CollectcallbackFun(data)  
       {  
           alert(data);
           $("#output").val(data.buildingName);
       }
       
       function importExcel()  
       {  
	       $.ajax({
	       type: "GET",
	       url: "buildingAction.do?action=importExcel",
	       success: successCallbackFun
			});
		}
		
		  function successCallbackFun()  
       {  
           alert("success");
       }

       function retriveStock(){
      		$.ajax({
      			type:"POST",
      			url : "buildingAction.do?action=retriveStockData",
      			success:successCallbackFun
      		});
       }

       
</script>
</html>