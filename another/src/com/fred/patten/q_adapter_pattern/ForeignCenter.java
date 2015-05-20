package com.fred.patten.q_adapter_pattern;

public class ForeignCenter{

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void jinGong() {
		System.out.println("ÖÐ·æ"+name+"½ø¹¥");
	}

	public void fanShou() {
		System.out.println("ÖÐ·æ"+name+"·ÀÊØ");
	}

}
