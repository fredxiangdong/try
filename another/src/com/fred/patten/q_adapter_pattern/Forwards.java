package com.fred.patten.q_adapter_pattern;

public class Forwards extends Player{

	public Forwards(String name){
		super(name);
	}
	
	@Override
	public void Attack() {
		System.out.println("ǰ��"+name+"����");
	}

	@Override
	public void Defense() {
		System.out.println("ǰ��"+name+"����");
	}

}
