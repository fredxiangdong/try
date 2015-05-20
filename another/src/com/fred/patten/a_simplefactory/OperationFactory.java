package com.fred.patten.a_simplefactory;

public class OperationFactory {
	
	public static Operation createOperation(int operate){
		Operation operation = null;
		switch(operate){
		case 1:
			operation = new OperationAdd();
			break;
		case 2:
			operation = new OperationSub();
			break;
		case 3:
			operation = new OperationMul();
			break;
		case 4:
			operation = new OperationDiv();
			break;
		}
		return operation;
	}
}