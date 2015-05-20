package com.fred.patten.z2_visitor_pattern;

public class ConcreteVisitor2 implements Visitor{

	public void visitConcreteElementA(ConcreteElementA concreteElementA) {
		System.out.println(concreteElementA.getClass().getName()+"被"+this.getClass().getName()+"访问");
	}

	public void visitConcreteElementB(ConcreteElementB concreteElementB) {
		System.out.println(concreteElementB.getClass().getName()+"被"+this.getClass().getName()+"访问");		
	}

}
