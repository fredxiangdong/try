package com.fred.patten.a_simplefactory;

public abstract class Operation {
	
	protected Double numA;
	protected Double numB;
	public Double getNumA() {
		return numA;
	}
	public void setNumA(Double numA) {
		this.numA = numA;
	}
	public Double getNumB() {
		return numB;
	}
	public void setNumB(Double numB) {
		this.numB = numB;
	}
	
	public abstract Double getResult() throws Exception;
}
