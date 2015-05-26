package com.fred.trying.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.fred.trying.entity.TbUser;
import com.fred.trying.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/easyui")
@ParentPackage("struts-default")
@Action(value ="loginAction")
@Results({
	@Result(name ="input", location ="easyui.jsp"),
	@Result(name ="login", location ="/login.jsp")
	})
public class LoginAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private String username;
	
	private String password;
	
	@Autowired
	private UserService userService;
	
	ActionContext context = ActionContext.getContext();
	Map session = context.getSession();
	
	public String execute(){
		this.login();
		Object user = session.get("user");
		if (user == null)
			return "login";
		else return INPUT;
	}

	
	public void login(){
		if(username == null || password == null)
			return;
		TbUser user = userService.retrive(username, password);
		if(user == null)
			return;
		else{
			session.put("user", user);
		}
	}
	
	public void loginout(){
		session.remove("user");
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
