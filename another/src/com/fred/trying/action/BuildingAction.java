package com.fred.trying.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.fred.poi.service.ImportExcelService;
import com.fred.stock.service.RetriveStockDataService;
import com.fred.trying.entity.CrmCommunityBuilding;
import com.fred.trying.service.BuildingService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/crm")
@Action(value="buildingAction")
@ParentPackage("struts-default")
@Results({
	@Result(name="input",location="building.jsp")
})
public class BuildingAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private String test="1";
	private CrmCommunityBuilding building;
	private List<CrmCommunityBuilding> buildingLs;
	private int buildingId;
	private String action;
	
	@Autowired
	private BuildingService buildingService;
	@Autowired
	private ImportExcelService importExcelService;
	@Autowired
	private RetriveStockDataService retriveStockDataService;
	
	HttpServletRequest request=  (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST); 
	HttpServletResponse response = (HttpServletResponse)ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
	PrintWriter out;
	
	 @Override
	public String execute(){ 
		 if("testAjax".equals(action)){
			 this.testAjax();
		 }else if("importExcel".equals(action)){
			 this.importExcel();
		 } else if("retriveStockData".equals(action)){
			 this.retriveStockData();
		 }
		 else{
        	buildingLs = buildingService.retriveAll(null);
			building = buildingLs.get(0);
			request.setAttribute("target","PKU");
		 }
		return "input";
	}
	 
	public String importExcel(){
		importExcelService.importExcel("D://1.xlsx");
		return "input";
	}
	
	public String retriveStockData(){
		retriveStockDataService.retriveData();
		return "input";
	}
	
	 @Action(value="testAjax")
	public String  testAjax(){
		buildingId = buildingId +1;
		try {
			out = response.getWriter();
			out.print(buildingId);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 return "input";
	}
	 
	 @Action(value="testAjaxCollect")
		public String  testAjaxCollect(){
		 building = buildingLs.get(0);
			try {
				out = response.getWriter();
				out.print(building);
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			 return "input";
		}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public CrmCommunityBuilding getBuilding() {
		return building;
	}

	public void setBuilding(CrmCommunityBuilding building) {
		this.building = building;
	}

	public List<CrmCommunityBuilding> getBuildingLs() {
		return buildingLs;
	}

	public void setBuildingLs(List<CrmCommunityBuilding> buildingLs) {
		this.buildingLs = buildingLs;
	}

	public int getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}
