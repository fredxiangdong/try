package com.fred.trying.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/easyui")
@Action(value ="easyUiUserAction")
@Results({
	@Result(name="input" ,location="userdata.jsp"),
	@Result(name = "demogrid",location = "easyuigrid.jsp")
})
public class EasyUiUserAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	public String execute(){
		return INPUT;
	}
	
	public String demogrid(){
		return "demogrid";
	}
}
