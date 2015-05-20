package com.fred.charts.fusionchart.entity;

import java.util.Random;
/* 
 *  ͼ�����ݼ��� 
 *  ���ܣ��������,���Զ�����ɫ��û���Զ�����ɫǰ12��ΪrandomColor��˳�� 
 *       ������������ѡ��randomColor��һ����ɫ 
 *  ���������Զ����ǿ�� ��Ҫ�Լ�����xmldata 
 *  set alpha = '50' ͸����Ϊ50%   
 *  set dashed='1' ����״̬��ʾ 
 *  set ����Line  anchorSides='7' ��ʾ�ĵ�Ϊ������   anchorRadius = '4' ��״��С  
 *  set anchorBorderColor='A186BE' �� �ı߿���ɫ     anchorBgColor='8BBA00' ��ı���ɫ 
 *  set �����û��value���� �������пռ� ֻ��û��ʾ  ��Ԫ��  
 */  
public class DataSet {  
    private String[] randomColor = new String[] {   
            "AFD8F8", "F6BD0F", "8BBA00","FF8E46","008E8E","D64646",  
            "8E468E", "588526", "B3AA00","008ED6", "9D080D", "A186BE" };  
    private String seriesName;  // ��ʾ  
    private String[] setNames; // ����  
    private String[] setValues;// ֵ  
    private String[] setColors;// ��ɫ  
    private String[] setTooltexts;// ��ʾ��Ϣtooltext='��Ϣ��{br}xxx...'  
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
     * ����������� 
     */  
    public String createDataSet() {  
        String dataSet = "<dataset seriesName='" + seriesName + "'>";  
        dataSet+=createSets(dataSet,false);  
        dataSet += "</dataset>";  
        return dataSet;  
    }  
    /* 
     * ���õ���ͨ��Column2D Column3D Line2D Line3D �� 
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
