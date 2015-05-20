<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
  
<title>图表Fusioncharts测试</title>  
<%@include file ="../../pageset.jspa" %>
 <script type="text/javascript" src="/another/plugin/FusionCharts/FusionCharts.js"></script>  
 <script type="text/javascript" src="/another/plugin/FusionCharts/FusionChartsExportComponent.js"></script>  
 <script type="text/javascript">  
    window.onload = function(){  
        //chart   x轴下标题文字  labelDisplay='Rotate'  垂直显示  slantLabels='1'  45 度倾斜  
        //chart  x轴下标题文字  labelDisplay = "Stagger"  staggerLines='n' 显示的行数 如果文字过长 就各行对应显示  
        //chart  x轴下标题文字  labelStep='n' 文字每隔几个一显示   
        // chart   x轴 上的柱顶部固定的文字值 rotateValues='1' 垂直显示  
        // set alpha = '50' 透明度为50%    
        // set dashed='1' 虚线状态显示  
        // set 对于Line  anchorSides='7' 显示的点为几边形   anchorRadius = '4' 形状大小   
        // set anchorBorderColor='A186BE' 点 的边框颜色     anchorBgColor='8BBA00' 点的背景色  
        // set 中如果没有value属性 还是留有空间 只是没显示  空元素   
        // chart connectNullData='1' 对于Line,跳过空元素直接与下一个节点连接      
                // lineDashGap='6' 虚线显示空元素的连接  需要程序处理上一个节点为dashed='1'  
        // chart lineDashGap = '5' 虚线的点的间隔  
        // chart decimals='2' 小数点后2位数  其他类似   对于数据差距比较很小(最大值最小值最少相差在1之内) 适用  
                //  如果想让柱状的值显示小数点后一位 forceDecimals='1' (Y轴显示还是2位或者更多)  
        // chart  formatNumberScale='0' 显示格式为 234,344,679  
        // chart formatNumberScale='0'  formatNumber='0' 显示格式为原始格式  
        // chart  clickURL='n-http://www.baidu.com'  chart点击打开百度   
        // chart toolTipBorderColor 提示的边框颜色 toolTipBgColor 提示的背景色   
        // chart useRoundEdges = '1'  chart展示圆柱状图表   
        // chart exportHandler='fcExporter1'  chart指定client-side导出组件  
        // 导出功能所需要的三件事情： 1 引入FusionChartsExportComponent.js 2 html中添加导出按钮的div(id = 'xy')  3 并设置相应的属性 exportAtClient = '1'支持客户端导出 exportEnabled = '1' 可导出  4 chart指定exportHandler  
        // chart  exportDialogMessage='已导出 ' 设置导出文件的时候百分比进度前的文字  
        var xx =    
            "<chart  caption = '自定义图表(点击倒数第二个&右键导出)' bgColor='FF5904,FFFFFF' bgAlpha='100,100' bgRatio='0,100' bgAngle='0'"  
            +" staggerLines='3'  labelDisplay='Stagger' labelStep='1' "  
            +" rotateValues='1' canvasPadding='0' connectNullData='1' lineDashGap='5'"  
            +" decimals='2' formatNumberScale='0'  formatNumber='0' exportEnabled='1'"  
            +" toolTipBorderColor='D9E5F1' toolTipBgColor='D9E5F1' showToolTip='1'   useRoundEdges='1'"  
            +" exportEnabled='1' exportAtClient='1' exportHandler='fcExporter1' exportDialogMessage='已导出 '>"   
                +"<set label='John' value='42900'  tooltext = '第1个值为{br}：420'/>"  
                +"<set label='Const' value='12345'  tooltext = '第2一个值为：295'/>"  
                +"<set label='Ivy' value='52233'  tooltext = '第3个值为：523'  dashed='1'/>"   
                +"<set label='Pery'  />"  
                +"<set label='Erlang'  />"  
                +"<set label='Chuank'   />"  
                +"<set label='Sprone' value='42000'  alpha='50' dashed='1' tooltext = '第1个值为{br}：420'/>"  
                +"<set label='July' value='2295'  tooltext = '第2一个值为：295'/>"  
                +"<set label='Lim' value='52243'  tooltext = '第3个值为：523'/>"  
                +"<set label='Joli' value='35679'  tooltext = '第1个值为{br}：420'/>"  
                +"<set label='Boyka' link='JavaScript:myJS(\"Boyka\");' value='68420'  tooltext = '第2一个值为：295'/>"  
                +"<set label='Abma'  link='JavaScript:myJS(\"Abma\");' value='52463'  tooltext = '第3个值为：523'/>"  
                +"<set label='Lanbo' link='JavaScript:myJS(\"Lanbo\");'  value='49990'  tooltext = '第1个值为{br}：420'/>"  
                +"<set label='Jim'  link='newchart-xml-jim-quarterly'  value='46999'  tooltext = '第2一个值为：295' color='FF5906' />"  
                +"<set label='Chelios' value='49900'  tooltext = '"+"杰森·斯坦森 主要作品{br}"  
                +"▪ 巴西任务 ( 2013)    ▪ 帕克 ( 2013){br}"  
                +"▪ 暂告安全 ( 2012)    ▪ 玩命追踪 ( 2012){br}"  
                +"▪ 波茨坦广场 ( 2012)▪ 敢死队2 ( 2012){br}"  
                +"▪ 铁血精英 ( 2011)    ▪ 机械师 ( 2010){br}"  
                +"▪ 死亡飞车2 ( 2010)▪ 敢死队 ( 2010){br}▪ 怒火攻心2 高压电"+"' color='FF5904' "  
                +" link='JavaScript:myJS(\"49900\");' anchorRadius='5' anchorSides='6' anchorBorderColor='A186BE' anchorBgColor='8BBA00'/>"  
            +" <linkeddata id='jim-quarterly'><chart caption='第一层转向(点击第二个进入)' subcaption='For the year 2004'    xAxisName='中国' yAxisName='GDP'>       <set label='Q1' value='11700'/>       <set label='Q2' link='newchart-xml-a-quarterly'  value='8600'/>       <set label='Q3' value='6900' />       <set label='Q4' value='10600' />"  
                +"<linkeddata id='a-quarterly'><chart caption='第二层转向' subcaption='浙江年度xx'    xAxisName='浙江' yAxisName='GPP'>       <set label='Q1' value='80'/>       <set label='Q2' value='50'/>       <set label='Q3' value='99' />       <set label='Q4' value='90' />    </chart>  </linkeddata></chart>  </linkeddata>"  
            +" <styles><style name='MyFirstBlur' type='Blur' blurX='6' blurY='6' /></styles></chart>";    
             // exportAtClient   exportEnabled='1'  加入fcexplorer.js   FusionChartsExportComponent.js  
         // FCExporter.swf 详细可见Client_side explorting-simple example   
            //  linkeddata 要转向的图的数据来源  
           var myChart = new FusionCharts("/another/plugin/FusionCharts/Column2D.swf", "myChartId234", "300", "300");  
           myChart.setDataXML(xx);       
           myChart.render("test");  
             
             
           var myExportComponent = new FusionChartsExportObject("fcExporter1", "/another/plugin/FusionCharts/FCExporter.swf");  
            myExportComponent.componentAttributes.width = '400';  
            myExportComponent.componentAttributes.height = '60';  
            //Background color  
            myExportComponent.componentAttributes.bgColor = 'ffffdd';  
            //Border properties  
            myExportComponent.componentAttributes.borderThickness = '2';  
            myExportComponent.componentAttributes.borderColor = '0372AB';  
            //Font properties  
            myExportComponent.componentAttributes.fontFace = 'Arial';  
            myExportComponent.componentAttributes.fontColor = '0372AB';  
            myExportComponent.componentAttributes.fontSize = '9';  
            myExportComponent.componentAttributes.btnWidth = '30';  
            myExportComponent.componentAttributes.btnHeight= '20';  
            myExportComponent.componentAttributes.btnColor = 'E1f5ff';  
            myExportComponent.componentAttributes.btnBorderColor = '0372AB';  
            //Button font properties  
            myExportComponent.componentAttributes.btnFontFace = 'Verdana';  
            myExportComponent.componentAttributes.btnFontColor = '0372AB';  
            myExportComponent.componentAttributes.btnFontSize = '15';  
            myExportComponent.componentAttributes.btnsavetitle = '保存';
            myExportComponent.componentAttributes.btndisabledtitle = '导出请点击右键...';   
            myExportComponent.Render("fce");//  
           //用configureLink可以指定不行形态的图表展现, 会替代掉原有的linkeddata   
           // 如果只有一个的话，可用下面，如果不是一种的话，下面代码不写。  
           /*  
            FusionCharts("myChartId234").configureLink (   
           {      
              swfUrl : "chart/swf/Pie3D.swf",  
                overlayButton:{  
                            message: '返回',  
                            fontColor : '880000',  
                            bgColor:'FFEEEE',  
                            borderColor: '660000'  
                }  
           }, 0);  
           */  
    };
    // 激发事件  
    function myJS(myVar){  
        window.alert(myVar);  
    }  
     $.ajax({  
           type: "POST",   
           url: "/another/crm/fusionchartAction!test1.do", //请求的action 
           dataType : "text", 
           success: function(data){ //结果  MSColumn2D  MSColumn3D  MSLine 
//            		var data = "<chart useRoundEdges='1'  caption='图表信息' xAxisName='月份' yAxisName='交易额' showValues= '0' numberPrefix='$'  yAxisMinValue = '0' yAxisMaxValue = '1200'><categories><category label='1月' /><category label='2月' /><category label='3月' /><category label='4月' /><category label='5月' /></categories><dataset seriesName='2000年'><set value='821'/><set value='309'/><set value='32'/><set value='919'/><set value='527'/></dataset><dataset seriesName='2001年'><set value='380'/><set value='588'/><set value='475'/><set value='65'/><set value='454'/></dataset><dataset seriesName='2002年'><set value='772'/><set value='925'/><set value='789'/><set value='756'/><set value='643'/></dataset> <trendlines><line startValue='26000' color='91C728' displayValue='Target'/></trendlines></chart>";
               var myChart = new FusionCharts("/another/plugin/FusionCharts/MSColumn2D.swf", "myChartId1", "300", "300");  
               myChart.setDataXML(data);        
               myChart.render("chartDiv1");  
                 
                 
               myChart = new FusionCharts("/another/plugin/FusionCharts/MSColumn3D.swf", "myChartId2", "300", "300");  
               myChart.setDataXML(data);        
               myChart.render("chartDiv2");  
                 
               myChart = new FusionCharts("/another/plugin/FusionCharts/MSLine.swf", "myChartId3", "300", "300");  
               myChart.setDataXML(data);        
               myChart.render("chartDiv3");  
                 
               myChart = new FusionCharts("/another/plugin/FusionCharts/MSArea.swf", "myChartId3_1", "300", "300");  
               myChart.setDataXML(data);        
               myChart.render("chartDiv3_1");  
                 
               myChart = new FusionCharts("/another/plugin/FusionCharts/MSCombi2D.swf", "myChartId3_2", "300", "300");  
               myChart.setDataXML(data);        
               myChart.render("chartDiv3_2");  
                 
               myChart = new FusionCharts("/another/plugin/FusionCharts/MSColumnLine3D.swf", "myChartId3_3", "350", "350");  
               myChart.setDataXML(data);        
               myChart.render("chartDiv3_3");  
                 
              
               //  纯3D 效果 可转动  
               myChart = new FusionCharts("/another/plugin/FusionCharts/MSCombi3D.swf", "myChartId3_5", "300", "300");  
               myChart.setDataXML(data);        
               myChart.render("chartDiv3_5");   
           }  
    });    
       
  $.ajax({  
           type: "POST",   
           url: "/another/crm/fusionchartAction!test2.do", //请求的action  
           dataType : "text",
           success: function(data){ //结果 Column2D Column3D Line Pie3D  
//            		  var data = "<graph  useRoundEdges='1'  caption='图表信息' xAxisName='月份' yAxisName='交易额' showValues= '0' numberPrefix='$'  yAxisMinValue = '0' yAxisMaxValue = '1200'><set name = '1月' value='190' color = 'F6BD0F'/><set name = '2月' value='334' color = 'AFD8F8'/><set name = '3月' value='799' color = 'FF8E46'/><set name = '4月' value='888' color = '008ED6'/><set name = '5月' value='900' color = 'A186BE'/></graph>";
                  var myChart = new FusionCharts("/another/plugin/FusionCharts/Column2D.swf", "myChartId4", "300", "300");  
                  myChart.setDataXML(data);        
                  myChart.render("chartDiv4");  
                    
                  myChart = new FusionCharts("/another/plugin/FusionCharts/Column3D.swf", "myChartId4", "300", "300");  
                  myChart.setDataXML(data);        
                  myChart.render("chartDiv5");  
                    
                  myChart = new FusionCharts("/another/plugin/FusionCharts/Line.swf", "myChartId6", "300", "300");  
                  myChart.setDataXML(data);        
                  myChart.render("chartDiv6");  
                    
                  myChart = new FusionCharts("/another/plugin/FusionCharts/Pie2D.swf", "myChartId7", "300", "300");  
                  myChart.setDataXML(data);        
                  myChart.render("chartDiv7");  
                    
                    
                    
                  myChart = new FusionCharts("/another/plugin/FusionCharts/Pie3D.swf", "myChartId8", "300", "300");  
                  myChart.setDataXML(data);        
                  myChart.render("chartDiv8");  
                    
                    ////////////////  其他效果  
                  myChart = new FusionCharts("/another/plugin/FusionCharts/SSGrid.swf", "myChartId9", "300", "300");  
                  myChart.setDataXML(data);        
                  myChart.render("chartDiv9");  
                    
                  
                   
                  myChart = new FusionCharts("/another/plugin/FusionCharts/Doughnut2D.swf", "myChartId12", "300", "300");  
                  myChart.setDataXML(data);        
                  myChart.render("chartDiv12");  
                  
                     
                  myChart = new FusionCharts("/another/plugin/FusionCharts/Doughnut3D.swf", "myChartId13", "300", "300");  
                  myChart.setDataXML(data);        
                  myChart.render("chartDiv13");  
                   
                  myChart = new FusionCharts("/another/plugin/FusionCharts/Area2D.swf", "myChartId14", "300", "300");  
                  myChart.setDataXML(data);        
                  myChart.render("chartDiv14");  
                    
                    
                  myChart = new FusionCharts("/another/plugin/FusionCharts/Bar2D.swf", "myChartId15", "300", "300");  
                  myChart.setDataXML(data);        
                  myChart.render("chartDiv15");  
           }  
    });   
       
 </script>  
</head>  
<body>  
  
    <table>  
        <tr>  
            <td><div id = "chartDiv1"></div></td>  
            <td><div id = "chartDiv2"></div></td>  
            <td><div id = "chartDiv3"></div></td>  
        </tr>  
          
        <tr>  
              
            <td><div id = "chartDiv3_1"></div></td>  
            <td><div id = "chartDiv3_2"></div></td>  
            <td><div id = "chartDiv3_3"></div></td>  
        </tr>  
          
        <tr>  
              
            <td><div id = "chartDiv3_4"></div></td>  
            <td><div id = "chartDiv3_5"></div></td>  
            <td><div id = "test"></div><div id = "fce"></div></td>  
        </tr>  
           
        <!--  下面是单列的图表 -->  
          
        <tr>  
            <td><div id = "chartDiv4"></div></td>  
            <td><div id = "chartDiv5"></div></td>  
            <td><div id = "chartDiv6"></div></td>  
        </tr>  
          
        <tr>  
            <td><div id = "chartDiv7"></div></td>  
            <td><div id = "chartDiv8"></div></td>  
            <td><div id = "chartDiv9"></div></td>  
        </tr>  
          
        <tr>  
            <td><div id = "chartDiv10"></div></td>  
            <td><div id = "chartDiv11"></div></td>  
            <td><div id = "chartDiv12"></div></td>  
        </tr>  
          
        <tr>  
            <td><div id = "chartDiv13"></div></td>  
            <td><div id = "chartDiv14"></div></td>  
            <td><div id = "chartDiv15"></div></td>  
        </tr>  
    </table>  
</body>  
</html> 