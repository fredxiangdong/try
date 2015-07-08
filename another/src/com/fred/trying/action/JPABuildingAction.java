package com.fred.trying.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.fred.common.baseaction.EasyGridAction;
import com.fred.common.sysmodel.EasyGridData;
import com.fred.trying.entity.JPACommunityBuilding;
import com.fred.trying.service.JPABuildingService;
import com.google.gson.Gson;

@Namespace("/crm")
@ParentPackage("json-default")
@Action(value="jpaBuildingAction")
@Results({
	@Result(name = "input", location = "buildjpa.jsp"),
	@Result(name = "add", location = "addbuilding.jsp"),
	@Result(name = "jsondata",type ="json",params = {"root","gridData"}),
	@Result(name = "addbck",type = "json", params = {"includeproperties","buildingId"}),
})

public class JPABuildingAction extends EasyGridAction<JPACommunityBuilding>{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private JPABuildingService buildingService;
	
	private EasyGridData<JPACommunityBuilding> gridData = new EasyGridData<JPACommunityBuilding>();
	
	private JPACommunityBuilding building;
	
	private String buildingId;
	
	private String total = "0";
	
	private String action;
	
	private String buildingStr;
	
//	private String page ;
//	private String rows;
	 
	@Override
	public String execute(){ 
		if("detail".equals(action)){
			this.detail();
			return "add";
		}else{
			return INPUT;
		} 
	}
	 
	 public void detail(){
		 building = buildingService.retriveById(buildingId);
	 }
	 
	public String retrive(){
		gridData.setRows(buildingService.retriveAll(getPageInfo())) ;
		gridData.setTotal( getPageInfo().getAllRowNum());
/*		rows = buildingService.retriveAll();
		total = String.valueOf(rows.size());*/
		return "jsondata";
	}
	
	public String add(){
		building = new JPACommunityBuilding();
		return "add";
	}

	public String save(){
		try {
			buildingStr =URLDecoder.decode(buildingStr,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		building = gson.fromJson(buildingStr,JPACommunityBuilding.class);
		building = buildingService.save(building);
		buildingId = building.getBuildingId();
		return "addbck";
	}
	
	public void del(){
		buildingService.delById(buildingId);
	}
	
	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public JPACommunityBuilding getBuilding() {
		return building;
	}

	public void setBuilding(JPACommunityBuilding building) {
		this.building = building;
	}

	public String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getBuildingStr() {
		return buildingStr;
	}

	public void setBuildingStr(String buildingStr) {
		this.buildingStr = buildingStr;
	}

	public EasyGridData<JPACommunityBuilding> getGridData() {
		return gridData;
	}

	public void setGridData(EasyGridData<JPACommunityBuilding> gridData) {
		this.gridData = gridData;
	}

}
