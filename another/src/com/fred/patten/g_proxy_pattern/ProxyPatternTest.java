package com.fred.patten.g_proxy_pattern;

public class ProxyPatternTest {

	public static void main(String[] args){
		SchoolGirl jiaojiao = new SchoolGirl();
		jiaojiao.setName("¿ÓΩøΩø");
		
		Proxy daili = new Proxy(jiaojiao);
		
		daili.GiveChocolate();
		daili.GiveDolls();
		daili.GiveFlowers();
		
	}
}
