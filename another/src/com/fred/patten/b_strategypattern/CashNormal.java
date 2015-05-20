package com.fred.patten.b_strategypattern;

public class CashNormal extends CashSuper{

	@Override
	public Double acceptCash(Double money) {
		return money;
	}

}
