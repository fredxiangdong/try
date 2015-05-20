package com.fred.patten.a_simplefactory;

public class SimpleFactoryTest {

	public static void main(String[] args){
		Operation operation = null;
		operation = OperationFactory.createOperation(4);
		operation.numA = 1.0;
		operation.numB = 2.0;
		Double result = 0.0;
		try {
			result = operation.getResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
	}
}
