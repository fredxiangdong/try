package com.fred.trying.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/crm")
@ParentPackage("struts-default")
@Action(value ="artDialogAction")
@Results({
	@Result(name ="input", location ="artdialogtest.jsp")
})
public class ArtDialogAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	public String execute(){
		return INPUT;
	}
}
