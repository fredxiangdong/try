package com.fred.trying.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.fred.trying.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/easyui")
@Action(value ="loginAction")
@Results({@Result(name="input", location="easyui.jsp")})
public class LoginAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private String username;
	
	private String password;
	
	public String execute(){
		User user =  new User("3","有时","祥东","男","烟台");
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		session.put("user", user);
		return INPUT;
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
