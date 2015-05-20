package com.fred.patten.q_adapter_pattern;

public class Translator extends Player{

	private ForeignCenter fc = new ForeignCenter();
	
	public Translator(String name){
		super(name);
		fc.setName(this.name);
	}
	
	@Override
	public void Attack() {
		fc.jinGong();
	}

	@Override
	public void Defense() {
		fc.fanShou();
	}

}
