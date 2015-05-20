package com.fred.patten.a_simplefactory;

public class OperationDiv extends Operation{

	@Override
	public Double getResult() throws Exception {
		if(numB == 0){
			throw new Exception("除数不能为零！");
		}
		return numA / numB;
	}
	
}
