package com.fred.patten.h_factory_pattern;

public class FactoryPatternTest {

	public static void main(String[] args){
		IFactory fatory = new UndergraduateFactory();
		Leifeng student = fatory.createLeifeng();
		
		student.sweep();
		student.wash();
		student.buyRice();
		
		IFactory volfatory = new VolunteerFactory();
		Leifeng vol = volfatory.createLeifeng();
		
		vol.sweep();
		vol.wash();
		vol.buyRice();
	}
}
