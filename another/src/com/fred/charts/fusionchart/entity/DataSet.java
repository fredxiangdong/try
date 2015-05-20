package com.fred.charts.fusionchart.entity;

import java.util.Random;
/* 
 *  图表数据集合 
 *  功能：组合数据,可自定义颜色，没有自定义颜色前12个为randomColor的顺序， 
 *       超过部分随意选择randomColor的一种颜色 
 *  对于下面自定义很强的 需要自己生成xmldata 
 *  set alpha = '50' 透明度为50%   
 *  set dashed='1' 虚线状态显示 
 *  set 对于Line  anchorSides='7' 显示的点为几边形   anchorRadius = '4' 形状大小  
 *  set anchorBorderColor='A186BE' 点 的边框颜色     anchorBgColor='8BBA00' 点的背景色 
 *  set 中如果没有value属性 还是留有空间 只是没显示  空元素  
 */  
public class DataSet {  
    private String[] randomColor = new String[] {   
            "AFD8F8", "F6BD0F", "8BBA00","FF8E46","008E8E","D64646",  
            "8E468E", "588526", "B3AA00","008ED6", "9D080D", "A186BE" };  
    private String seriesName;  // 标示  
    private String[] setNames; // 名称  
    private String[] setValues;// 值  
    private String[] setColors;// 颜色  
    private String[] setTooltexts;// 提示信息tooltext='信息：{br}xxx...'  
    public String[] getSetNames() {  
        return setNames;  
    }  
    public void setSetNames(String[] setNames) {  
        this.setNames = setNames;  
    }  
    public String[] getSetColors() {  
        return setColors;  
    }  
    public void setSetColors(String[] setColors) {  
        this.setColors = setColors;  
    }  
    public String getSeriesName() {  
        return seriesName;  
    }  
    public void setSeriesName(String seriesName) {  
        this.seriesName = seriesName;  
    }  
    public String[] getSetValues() {  
        return setValues;  
    }  
    public void setSetValues(String[] setValues) {  
        this.setValues = setValues;  
    }  
    public String[] getSetTooltexts() {
		return setTooltexts;
	}
	public void setSetTooltexts(String[] setTooltexts) {
		this.setTooltexts = setTooltexts;
	}
	/* 
     * 多列数据组合 
     */  
    public String createDataSet() {  
        String dataSet = "<dataset seriesName='" + seriesName + "'>";  
        dataSet+=createSets(dataSet,false);  
        dataSet += "</dataset>";  
        return dataSet;  
    }  
    /* 
     * 公用到普通的Column2D Column3D Line2D Line3D 等 
     */  
    public String createSets(String dataSet,boolean boo) {  
        String newDataSet = "";  
        for (int i = 0; i < setValues.length; i++) {  
            if (setColors != null) {  
                if (setNames != null) {  
                    newDataSet += "<set name = '" + setNames[i] + "' value='" + setValues[i] + "' color = '" + setColors[i]+ "'/>";  
                } else{  
                    if(boo){  
                        if(i>randomColor.length){  
                            int ai = new Random().nextInt(12);  
                            newDataSet += "<set value='" + setValues[i] + "' color = '" + randomColor[ai] + "'/>";  
                        }else{  
                            newDataSet += "<set value='" + setValues[i] + "' color = '" + setColors[i] + "'/>";  
                        }  
                          
                    }else{  
                        newDataSet += "<set value='" + setValues[i] + "' color = '" + setColors[i] + "'/>";  
                    }  
                }  
            } else {  
                newDataSet += "<set value='" + setValues[i] + "'/>";  
            }  
        }  
        return newDataSet;  
    }  
}
