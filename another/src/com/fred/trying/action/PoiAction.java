package com.fred.trying.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fred.poi.entity.RoadSign;
import com.fred.poi.service.ImportDocService;
import com.fred.poi.service.ImportExcelService;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/crm")
@ParentPackage("struts-default")
@Action(value="poiAction")
@Results({
	@Result(name ="input", location ="poitest.jsp")
})
public class PoiAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private String excelPath;
	private String docPath;
	
	@Autowired
	private ImportExcelService importExcelService;
	@Autowired
	private ImportDocService importDocService;
	
	public String getDocPath() {
		return docPath;
	}

	public void setDocPath(String docPath) {
		this.docPath = docPath;
	}

	public String getExcelPath() {
		return excelPath;
	}

	public void setExcelPath(String excelPath) {
		this.excelPath = excelPath;
	}

	@Override
	public String execute(){
		excelPath = "E:/1.xls";
		docPath = "E:/1.doc";
		return INPUT;
	}
	
	public void testPOI(){
		importExcelService.importExcel(excelPath);
	}
	
	@SuppressWarnings("unchecked")
	public void testDocPOI(){
		ArrayList<RoadSign> signLs = importDocService.readSignFromDoc(docPath);
		//FileSystemXmlApplicationContext方式获取配置文件
//		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
		//ClassPathXmlApplicationContext方式获取配置文件
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationPath.xml");
		String filePath = ((Map<String,String>)context.getBean("appExtConfig")).get("filePath");
		importDocService.writeRoadSignToExcl(filePath, filePath + "公路标志基础数据_位置信息.xls", signLs, "公路标志");
	}
}
