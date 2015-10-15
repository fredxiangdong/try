package com.fred.patten.v_bridge_pattern;

public abstract class Abstraction {
	
	public Implementor implementor;
	
	public void setImplementor(Implementor implementor){
		this.implementor = implementor;
	}
	
	public  void Operation(){
//		implementor.Operation();
	}
}
