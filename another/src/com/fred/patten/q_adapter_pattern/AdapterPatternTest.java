package com.fred.patten.q_adapter_pattern;

public class AdapterPatternTest {

	public static void main(String[] args){
		
		Player b = new Forwards("�͵ٶ�");
		b.Attack();
		
		Player m = new Guards("��˸��׵�");
		m.Attack();
		
		Player ym = new Translator("Ҧ��");
		ym.Attack();
		ym.Defense();
	}
}
