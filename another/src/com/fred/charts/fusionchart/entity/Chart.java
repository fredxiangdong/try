package com.fred.charts.fusionchart.entity;

/* 
* ͼ���� 
* ���ܣ�֧��MS����ϵ��ͼ���͵���ϵ��ͼ�� 
*  ���������Զ����ǿ�� ��Ҫ�Լ�����xmldata 
*  chart   x���±�������  labelDisplay='Rotate'  ��ֱ��ʾ  slantLabels='1'  45 ����б 
*  chart  x���±�������  labelDisplay = "Stagger"  staggerLines='n' ��ʾ������ ������ֹ��� �͸��ж�Ӧ��ʾ 
*  chart  x���±�������  labelStep='n' ����ÿ������һ��ʾ  
*  chart   x�� �ϵ��������̶�������ֵ rotateValues='1' ��ֱ��ʾ 
*  chart connectNullData='1' ����Line,������Ԫ��ֱ������һ���ڵ�����     
               // lineDashGap='6' ������ʾ��Ԫ�ص�����  ��Ҫ��������һ���ڵ�Ϊdashed='1' 
*  chart lineDashGap = '5' ���ߵĵ�ļ�� 
*  chart decimals='2' С�����2λ��  ��������   �������ݲ��ȽϺ�С(���ֵ��Сֵ���������1֮��) ���� 
               //  ���������״��ֵ��ʾС�����һλ forceDecimals='1' (Y����ʾ����2λ���߸���) 
*  chart  formatNumberScale='0' ��ʾ��ʽΪ 234,344,679 
*  chart formatNumberScale='0'  formatNumber='0' ��ʾ��ʽΪԭʼ��ʽ 
*/  
public class Chart {  
   private String caption;// ����  
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
    * MS ����ϵ�� 
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
    * ����ͼ��ϵ�� 
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