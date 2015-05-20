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
	@Result(name = "jsondata",type ="json",params = {"includeproperties","buildingLs.*"})
})
public class JPABuildingAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	@Autowired
	private JPABuildingService buildingService;
	
	private List<JPACommunityBuilding> buildingLs = new ArrayList<JPACommunityBuilding>();
	 
	 
	 @Override
	public String execute(){ 
		return INPUT;
	}
	 
	public String retrive(){
		buildingLs = buildingService.retriveAll();
		return "jsondata";
		
	}
}
