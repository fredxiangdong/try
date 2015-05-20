package com.fred.trying.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/crm")
@Action(value = "echartShowDemoAction")
@ParentPackage("struts-default")
@Results({
	@Result(name = "input",location = "echart.jsp")
})
public class EchartShowDemoAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	public String execute(){
		return INPUT;
	}
}
