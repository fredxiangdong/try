package com.fred.patten.q_adapter_pattern;

public class Guards extends Player{

	public Guards(String name){
		super(name);
	}
	
	@Override
	public void Attack() {
		System.out.println("ºóÎÀ"+name+"½ø¹¥");
	}

	@Override
	public void Defense() {
		System.out.println("ºóÎÀ"+name+"·ÀÊØ");
	}
}
