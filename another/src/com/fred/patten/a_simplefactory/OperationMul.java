package com.fred.patten.a_simplefactory;

public class OperationMul extends Operation{

	@Override
	public Double getResult() throws Exception{
		return numA * numB;
	}

}
