package com.fred.patten.z2_visitor_pattern;

public class ConcreteElementB extends Element{

	@Override
	public void Accept(Visitor visitor) {
		visitor.visitConcreteElementB(this);
	}
	
	public void OperationB(){}
}
