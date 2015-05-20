package com.fred.patten.f_decoratepattern;

public class Person {

	protected String name;
	
	public Person(){}
	
	public Person(String name){
		this.name = name;
	}
	
	public void show(){
		System.out.println("×°°çµÄ"+name);
	};
}
