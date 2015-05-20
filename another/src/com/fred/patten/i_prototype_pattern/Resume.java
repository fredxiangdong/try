package com.fred.patten.i_prototype_pattern;

public class Resume {
	
	private String name;
	private String sex;
	private String age;
	private String timeArea;
	private String company;
	
	public Resume(){}
	
	public Resume(String name){
		this.name = name;
	}
	
	public Resume(String name, String sex, String age, String timeArea, String company){
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.timeArea = timeArea;
		this.company = company;
	}
	
	public void setPersonalInfo(String sex, String age){
		this.sex = sex;
		this.age = age;
	}
	
	public void setWorkExperience(String timeArea, String company){
		this.timeArea = timeArea;
		this.company = company;
	}
	
	public void display(){
		System.out.println(name+sex+age);
		System.out.println("工作经历："+ timeArea + company);
	}
	
	public Resume clone(){
		return new Resume(name,sex,age,timeArea,company);
	}
	
}
