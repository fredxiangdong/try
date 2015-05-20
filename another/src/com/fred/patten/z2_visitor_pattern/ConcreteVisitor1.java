package com.fred.patten.z2_visitor_pattern;

public class ConcreteVisitor1 implements Visitor{

	public void visitConcreteElementA(ConcreteElementA concreteElementA) {
		System.out.println(concreteElementA.getClass().getName()+"��"+this.getClass().getName()+"����");
	}

	public void visitConcreteElementB(ConcreteElementB concreteElementB) {
		System.out.println(concreteElementB.getClass().getName()+"��"+this.getClass().getName()+"����");		
	}

}
