package com.fred.patten.a_simplefactory;

public class OperationDiv extends Operation{

	@Override
	public Double getResult() throws Exception {
		if(numB == 0){
			throw new Exception("��������Ϊ�㣡");
		}
		return numA / numB;
	}
	
}
