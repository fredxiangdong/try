package com.fred.trying.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.fred.charts.fusionchart.entity.Chart;
import com.fred.charts.fusionchart.entity.DataSet;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/crm")
@ParentPackage("json-default")
@Action(value ="fusionchartAction")
@Results({
	@Result(name ="input" , location ="fusionchart.jsp"),
	@Result(name ="chart" , type = "json" , params ={"contentType","text/html"}),
})
public class FusionchartAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private String xmlData;
	HttpServletResponse response = ServletActionContext.getResponse();

	public String getXmlData() {
		return xmlData;
	}

	public void setXmlData(String xmlData) {
		this.xmlData = xmlData;
	}

	public String execute(){
		return INPUT;
	}
	
	public String test1() {//  随时测试  
		response.setCharacterEncoding("UTF-8");
	    Chart chart = new Chart();  
	    chart.setCaption("图表信息");  
	    chart.setxAxisName("月份");  
	    chart.setyAxisName("交易额");  
	    chart.setShowValues("0");  //0则图表上不显示数据，1则显示
	    chart.setNumberPrefix("$");  
	    String[] cs = { "1月", "2月", "3月", "4月", "5月" };  
	    chart.setCategories(cs);  
	    DataSet[] ds = new DataSet[3];// 三个进行对比  
	    for (int i = 0; i < ds.length; i++) {  
	        ds[i] = new DataSet(); // 对比五个月的数据  
	        ds[i].setSeriesName("201" + i + "年");  
	        int a1 = new Random().nextInt(1000);  
	        int a2 = new Random().nextInt(1000);  
	        int a3 = new Random().nextInt(1000);  
	        int a4 = new Random().nextInt(1000);  
	        int a5 = new Random().nextInt(1000);  
	        String[] sv = { "" + a1, "" + a2, "" + a3, "" + a4, "" + a5 };  
	        ds[i].setSetValues(sv);  
	    }  
	    chart.setDataset(ds);  
	    chart.setLineStartValue("26000");  
	    chart.setLineColor("91C728");  
	    chart.setLineDisplayValue("Target");  
	    chart.setyAxisMinValue("0"); // 最小值  
	    chart.setyAxisMaxValue("1200");// 最大值  
	    xmlData = chart.createChartXmlData();  
	    System.out.println(xmlData);
	    try {
	    	PrintWriter out = response.getWriter(); 
	    	out.print(xmlData);
	    	out.flush();
	    	out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    return null;
	}  
	
	@SuppressWarnings("all")
	public String test2() {  
		response.setCharacterEncoding("UTF-8");  
	    Chart chart = new Chart();  
	    chart.setCaption("图表信息");  
	    chart.setxAxisName("月份");  
	    chart.setyAxisName("交易额");  
	    chart.setShowValues("0");  
	    chart.setNumberPrefix("$");  
	    String[] cs = { "1月", "2月", "3月", "4月", "5月" };  
	    DataSet[] ds = new DataSet[1];// 三个进行对比  
	    ds[0] = new DataSet(); // 对比五个月的数据  
	    ds[0].setSeriesName("2000年");  
	    ds[0].setSetNames(cs);  
	    String[] sv = { "" + 190, "" + 334, "" + 799, "" + 888, "" + 900 };  
	    String[] sc = { "F6BD0F", "AFD8F8", "FF8E46", "008ED6", "A186BE" };  
	    ds[0].setSetColors(sc);  
	    ds[0].setSetValues(sv);  
	    chart.setDataset(ds);  
	    chart.setyAxisMinValue("0"); // 最小值  
	    chart.setyAxisMaxValue("1200");// 最大值  
	    xmlData = chart.createRoutineChartXmlData();  
	    System.out.println(xmlData);
	    PrintWriter pw;  
	    try {  
	        pw = response.getWriter();  
	        pw.print(xmlData); 
	        pw.flush();
	        pw.close();
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  
		return null;
	}  
}
