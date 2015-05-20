package com.fred.patten.b_strategypattern;

public class CashRebate extends CashSuper{

	private Double moneyRebate = 1d;
	
	public CashRebate(Double moneyRebate){
		this.moneyRebate = moneyRebate;
	}
	
	@Override
	public Double acceptCash(Double money) {
		return money * moneyRebate;
	}

}
