package com.fred.trying.entity;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	private String userId;
	private String userName;
	private String name;
	private String sex;
	private String department;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

	public User(){}
	
	public User(String userId,String userName,String name,String sex,String department){
		this.userId = userId;
		this.userName = userName;
		this.name = name;
		this.sex = sex;
		this.department = department;
	}
}
