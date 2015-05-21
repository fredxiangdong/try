package com.fred.trying.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.fred.trying.entity.JPACommunityBuilding;
import com.fred.trying.service.JPABuildingService;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/crm")
@ParentPackage("json-default")
@Action(value="jpaBuildingAction")
@Results({
	@Result(name = "input", location = "jpabuilding.jsp"),
	@Result(name = "add", location = "addbuilding.jsp"),
	@Result(name = "jsondata",type ="json",params = {"includeproperties","rows.*,total"})
})
public class JPABuildingAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private JPABuildingService buildingService;
	
	private List<JPACommunityBuilding> rows = new ArrayList<JPACommunityBuilding>();
	
	private JPACommunityBuilding building;
	
	private String total = "0";
	 
	 @Override
	public String execute(){ 
		return INPUT;
	}
	 
	public String retrive(){
		rows = buildingService.retriveAll();
		total = String.valueOf(rows.size());
		return "jsondata";
	}
	
	public String add(){
		return "add";
	}

	public String save(){
		building = buildingService.save(building);
		return "add";
	}
	
	public List<JPACommunityBuilding> getRows() {
		return rows;
	}

	public void setRows(List<JPACommunityBuilding> rows) {
		this.rows = rows;
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
	
}
