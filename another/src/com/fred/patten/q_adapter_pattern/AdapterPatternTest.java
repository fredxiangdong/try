package com.fred.patten.q_adapter_pattern;

public class AdapterPatternTest {

	public static void main(String[] args){
		
		Player b = new Forwards("°ÍµÙ¶û");
		b.Attack();
		
		Player m = new Guards("Âó¿Ë¸ñÀ×µÏ");
		m.Attack();
		
		Player ym = new Translator("Ò¦Ã÷");
		ym.Attack();
		ym.Defense();
	}
}
