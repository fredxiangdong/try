package com.fred.patten.y_mediator_pattern;

public class Iraq extends Country{

	public Iraq(UnitedNations mediator) {
		super(mediator);
	}
	
	public void Declare(String message){
		mediator.Declare(message, this);
	}
	
	public void getMessage(String message){
		System.out.println("�����˻�öԷ���Ϣ��"+message);
	}
}
