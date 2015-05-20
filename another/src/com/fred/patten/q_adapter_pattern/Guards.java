package com.fred.patten.q_adapter_pattern;

public class Guards extends Player{

	public Guards(String name){
		super(name);
	}
	
	@Override
	public void Attack() {
		System.out.println("����"+name+"����");
	}

	@Override
	public void Defense() {
		System.out.println("����"+name+"����");
	}
}
