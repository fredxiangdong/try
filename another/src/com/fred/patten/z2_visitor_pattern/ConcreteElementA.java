package com.fred.patten.z2_visitor_pattern;

public class ConcreteElementA extends Element{

	@Override
	public void Accept(Visitor visitor) {
		visitor.visitConcreteElementA(this);
	}

	public void OperationA(){}
}
