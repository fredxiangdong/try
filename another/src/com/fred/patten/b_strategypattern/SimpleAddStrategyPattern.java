package com.fred.patten.b_strategypattern;

public class SimpleAddStrategyPattern {
	
	private static Double total = 0d;
	
	private static void calculateMoney(int i, Double money){
		SimpleAddStrategyCashContext ct = new SimpleAddStrategyCashContext(i);
		total = ct.getResult(money);
	}
	
	public static void main(String[] args){
		calculateMoney(3, 350d);
		System.out.println(total);
	}
}
