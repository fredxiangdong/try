package com.fred.charts.fusionchart.entity;

/* 
* 图表工具 
* 功能：支持MS多列系列图表，和单例系列图标 
*  对于下面自定义很强的 需要自己生成xmldata 
*  chart   x轴下标题文字  labelDisplay='Rotate'  垂直显示  slantLabels='1'  45 度倾斜 
*  chart  x轴下标题文字  labelDisplay = "Stagger"  staggerLines='n' 显示的行数 如果文字过长 就各行对应显示 
*  chart  x轴下标题文字  labelStep='n' 文字每隔几个一显示  
*  chart   x轴 上的柱顶部固定的文字值 rotateValues='1' 垂直显示 
*  chart connectNullData='1' 对于Line,跳过空元素直接与下一个节点连接     
               // lineDashGap='6' 虚线显示空元素的连接  需要程序处理上一个节点为dashed='1' 
*  chart lineDashGap = '5' 虚线的点的间隔 
*  chart decimals='2' 小数点后2位数  其他类似   对于数据差距比较很小(最大值最小值最少相差在1之内) 适用 
               //  如果想让柱状的值显示小数点后一位 forceDecimals='1' (Y轴显示还是2位或者更多) 
*  chart  formatNumberScale='0' 显示格式为 234,344,679 
*  chart formatNumberScale='0'  formatNumber='0' 显示格式为原始格式 
*/  
public class Chart {  
   private String caption;// 标题  
   private String xAxisName;  
   private String yAxisName;  
   private String showValues;  
   private String numberPrefix;  
   private String[] categories;  
   private DataSet[] dataset;  
   private String lineStartValue;  
   private String lineColor;  
   private String lineDisplayValue;  
   private String yAxisMinValue;  
   private String yAxisMaxValue;  
 
   public String getyAxisMinValue() {  
       return yAxisMinValue;  
   }  
 
   public void setyAxisMinValue(String yAxisMinValue) {  
       this.yAxisMinValue = yAxisMinValue;  
   }  
 
   public String getyAxisMaxValue() {  
       return yAxisMaxValue;  
   }  
 
   public void setyAxisMaxValue(String yAxisMaxValue) {  
       this.yAxisMaxValue = yAxisMaxValue;  
   }  
 
   public String getCaption() {  
       return caption;  
   }  
 
   public void setCaption(String caption) {  
       this.caption = caption;  
   }  
 
   public String getxAxisName() {  
       return xAxisName;  
   }  
 
   public void setxAxisName(String xAxisName) {  
       this.xAxisName = xAxisName;  
   }  
 
   public String getyAxisName() {  
       return yAxisName;  
   }  
 
   public void setyAxisName(String yAxisName) {  
       this.yAxisName = yAxisName;  
   }  
 
   public String getShowValues() {  
       return showValues;  
   }  
 
   public void setShowValues(String showValues) {  
       this.showValues = showValues;  
   }  
 
   public String getNumberPrefix() {  
       return numberPrefix;  
   }  
 
   public void setNumberPrefix(String numberPrefix) {  
       this.numberPrefix = numberPrefix;  
   }  
 
   public String[] getCategories() {  
       return categories;  
   }  
 
   public void setCategories(String[] categories) {  
       this.categories = categories;  
   }  
 
   public DataSet[] getDataset() {  
       return dataset;  
   }  
 
   public void setDataset(DataSet[] dataset) {  
       this.dataset = dataset;  
   }  
 
   public String getLineStartValue() {  
       return lineStartValue;  
   }  
 
   public void setLineStartValue(String lineStartValue) {  
       this.lineStartValue = lineStartValue;  
   }  
 
   public String getLineColor() {  
       return lineColor;  
   }  
 
   public void setLineColor(String lineColor) {  
       this.lineColor = lineColor;  
   }  
 
   public String getLineDisplayValue() {  
       return lineDisplayValue;  
   }  
 
   public void setLineDisplayValue(String lineDisplayValue) {  
       this.lineDisplayValue = lineDisplayValue;  
   }  
   /* 
    * MS 多列系列 
    */  
   public String createChartXmlData() {  
       String chartXmlData = "<chart useRoundEdges='1'  caption='" + caption + "' xAxisName='"  
               + xAxisName + "' yAxisName='" + yAxisName + "' showValues= '"  
               + showValues + "' numberPrefix='" + numberPrefix + "' "  
               + " yAxisMinValue = '" + yAxisMinValue + "' yAxisMaxValue = '"  
               + yAxisMaxValue + "'>";  
       ;  
       chartXmlData += "<categories>";  
       for (int i = 0; i < categories.length; i++) {  
           chartXmlData += "<category label='" + categories[i] + "' />";  
       }  
       chartXmlData += "</categories>";  
       for (int i = 0; i < dataset.length; i++) {  
           chartXmlData += dataset[i].createDataSet();  
       }  
       chartXmlData += " <trendlines><line startValue='" + lineStartValue  
               + "' color='" + lineColor + "' displayValue='"  
               + lineDisplayValue + "'/></trendlines>";  
       chartXmlData += "</chart>";  
       return chartXmlData;  
   }  
   /* 
    * 单个图标系列 
    */  
   public String createRoutineChartXmlData() {  
       String chartXmlData = "<graph  useRoundEdges='1'  caption='" + caption + "' xAxisName='"  
               + xAxisName + "' yAxisName='" + yAxisName + "' showValues= '"  
               + showValues + "' numberPrefix='" + numberPrefix + "' "  
               + " yAxisMinValue = '" + yAxisMinValue + "' yAxisMaxValue = '"  
               + yAxisMaxValue + "'>";  
       chartXmlData += dataset[0].createSets("",true);  
       chartXmlData += "</graph>";  
       return chartXmlData;  
   }  
}