package com.fred.patten.q_adapter_pattern;

public class Forwards extends Player{

	public Forwards(String name){
		super(name);
	}
	
	@Override
	public void Attack() {
		System.out.println("Ç°·æ"+name+"½ø¹¥");
	}

	@Override
	public void Defense() {
		System.out.println("Ç°·æ"+name+"·ÀÊØ");
	}

}
