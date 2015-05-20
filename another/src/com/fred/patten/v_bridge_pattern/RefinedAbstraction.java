package com.fred.patten.v_bridge_pattern;

public class RefinedAbstraction extends Abstraction{

	@Override
	public void Operation(){
		implementor.Operation();
	}
}
