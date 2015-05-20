package com.fred.patten.b_strategypattern;

public class SimpleAddStrategyCashContext {

	private CashSuper cs = null;
	
	public SimpleAddStrategyCashContext(int strategyNum){
		switch (strategyNum){
		case 1:
			cs = new CashNormal();
			break;
		case 2:
			cs = new CashReturn(300d,100d);
			break;
		case 3:
			cs = new CashRebate(0.8);
			break;
		}
	}
	
	public Double getResult(Double money){
		return cs.acceptCash(money);
	}
}
