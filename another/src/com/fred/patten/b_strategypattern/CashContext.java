package com.fred.patten.b_strategypattern;

public class CashContext {

	private CashSuper cs;
	
	public CashContext(CashSuper cssuper){
		this.cs = cssuper;
	}
	
	public Double getResult(Double money){
		return cs.acceptCash(money);
	}
}
