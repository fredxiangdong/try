package com.fred.trying.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.fred.common.jasper.JasperUtil;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/crm")
@Action(value="jasperAction")
@ParentPackage("struts-default")
@Results({
	@Result(name ="input", location = "jasper.jsp")
})
public class JasperAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	public String execute(){
		return INPUT;
	}
	
	public void testJasper(){
		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("acceptNum", "acceptNum");
		map.put("company", "HaiyiSoft");
//		map.put("applyTime", HyCommonUtil.getDateTime());
//		map.put("temp", "AT K1+000 to K2+000 drive");
//		map.put("time", HyCommonUtil.getDateTime());
		String newFileName  = "testJasper";
		try{
			JasperUtil.exportmain(JasperUtil.PDF_TYPE,"report6.jasper", null, map, newFileName);
		}catch (Exception e){
			e.printStackTrace();
		}
//		JasperUtil.exportPdfDir("report.jasper", map);
//		JasperUtil.exportWordDir("report.jasper", map, null);
	}
}
