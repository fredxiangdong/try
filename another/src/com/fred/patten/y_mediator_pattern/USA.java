package com.fred.patten.y_mediator_pattern;

public class USA extends Country{

	public USA(UnitedNations mediator) {
		super(mediator);
	}
	
	public void Declare(String message){
		mediator.Declare(message, this);
	}
	
	public void getMessage(String message){
		System.out.println("美国获得对方信息："+message);
	}
}
