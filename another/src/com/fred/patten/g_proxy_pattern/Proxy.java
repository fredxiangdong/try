package com.fred.patten.g_proxy_pattern;

public class Proxy implements GiveGift{

	private Persuit gg;
	
	public Proxy(SchoolGirl mm){
		gg = new Persuit(mm);
	}
	
	public void GiveDolls() {
		gg.GiveDolls();		
	}

	public void GiveFlowers() {
		gg.GiveFlowers();
	}

	public void GiveChocolate() {
		gg.GiveChocolate();
	}

}
