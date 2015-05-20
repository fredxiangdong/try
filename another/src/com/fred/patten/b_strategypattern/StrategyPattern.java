package com.fred.patten.b_strategypattern;

public class StrategyPattern {

	private static Double total = 0d;
	
	public static void getCashResult(int strNum,Double money){
		CashContext cc = null;
		switch(strNum){
		case 1:
			cc = new CashContext(new CashNormal());
			break;
		case 2:
			cc = new CashContext(new CashReturn(300d,100d));
			break;
		case 3:
			cc = new CashContext(new CashRebate(0.8));
			break;
		}
		total = cc.getResult(money);
	}
	
	public static void main(String[] args){
		getCashResult(2,250d);
		System.out.println(total);
	}
}
