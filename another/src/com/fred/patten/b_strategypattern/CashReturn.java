package com.fred.patten.b_strategypattern;

public class CashReturn extends CashSuper{

	private Double moneyCondition = 0d;
	private Double moneyReturn = 0d;
	
	public CashReturn(Double moneyCondition, Double moneyReturn){
		this.moneyCondition = moneyCondition;
		this.moneyReturn = moneyReturn;
	}
	
	@Override
	public Double acceptCash(Double money) {
		if(money > moneyCondition){
			money = money - moneyReturn;
		}
		return money;
	}

}
