package com.fred.trying.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="TB_USER")
public class TbUser implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name ="USER_ID")
	private String userId;
	@Column(name ="USER_NAME")
	private String userName;
	@Column(name ="REAL_NAME")
	private String name;
	@Column(name ="SEX")
	private String sex;
	@Column(name ="DEPARTMENT")
	private String department;
	@Column(name ="PASSWORD")
	private String password;
	@Column(name = "UNIT_CODE")
	private String unitCode;
	
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

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUnitCode() {
		return unitCode;
	}
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}
	public TbUser(){}
	
	public TbUser(String userId,String userName,String name,String sex,String department){
		this.userId = userId;
		this.userName = userName;
		this.name = name;
		this.sex = sex;
		this.department = department;
	}
}
