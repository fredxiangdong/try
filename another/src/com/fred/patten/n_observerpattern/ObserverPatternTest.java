package com.fred.patten.n_observerpattern;

public class ObserverPatternTest {

	public static void main(String[] args){
		
		ConcreteSubject s = new ConcreteSubject();
		
		s.attach(new ConcreteObserver(s,"X"));
		s.attach(new ConcreteObserver(s,"Y"));
		s.attach(new ConcreteObserver(s,"Z"));
		
		s.setSubjectStatus("ABC");
		s.notifyUser();
	}
}
