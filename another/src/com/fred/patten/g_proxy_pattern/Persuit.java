package com.fred.patten.g_proxy_pattern;

public class Persuit implements GiveGift{

	private SchoolGirl mm;
	
	public Persuit(SchoolGirl mm){
		this.mm = mm;
	}
	
	public void GiveDolls() {
		System.out.println(mm.getName()+"����������");
	}

	public void GiveFlowers() {
		System.out.println(mm.getName()+"�����ʻ�");
	}

	public void GiveChocolate() {
		System.out.println(mm.getName()+"�����ɿ���");
	}

}
