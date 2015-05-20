package com.fred.patten.v_bridge_pattern;

public class BridgePatternTest {

	public static void main(String[] args){
		Abstraction ab = new RefinedAbstraction();
		
		ab.setImplementor(new ConcreteImplementorA());
		ab.Operation();
		
		ab.setImplementor(new ConcreteImplementorB());
		ab.Operation();
	}
}
