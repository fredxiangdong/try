package com.fred.patten.z_flyweight_pattern;

public class ConcreteWebsite extends WebSite{

	private String name = "";
	
	public ConcreteWebsite(String name){
		this.name = name;
	}
	
	@Override
	public void Use(User user) {
		System.out.println("��վ���ࣺ"+name+"�û�"+user.getName());
	}

}
