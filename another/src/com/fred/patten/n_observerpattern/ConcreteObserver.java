package com.fred.patten.n_observerpattern;

public class ConcreteObserver implements Observer{

	private String name;
	private ConcreteSubject subject;
	
	public ConcreteObserver(ConcreteSubject subject, String name){
		this.name = name;
		this.subject = subject;
	}
	
	public void update() {
		System.out.println("观察者"+name+"的新状态是"+subject.getSubjectStatus());
	}

	public ConcreteSubject getSubject() {
		return subject;
	}

	public void setSubject(ConcreteSubject subject) {
		this.subject = subject;
	}

}
