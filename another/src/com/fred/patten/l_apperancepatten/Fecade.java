package com.fred.patten.l_apperancepatten;

public class Fecade {

	private SubSystemOne one;
	private SubSystemTwo two;
	private SubSystemThree three;
	private SubSystemFour four;
	
	public Fecade(){
		one = new SubSystemOne();
		two = new SubSystemTwo();
		three = new SubSystemThree();
		four = new SubSystemFour();
	}
	
	public void methodA(){
		System.out.println("方法组A：----");
		one.methodOne();
		two.methodTwo();
		four.methodFour();
	}
	
	public void methodB(){
		System.out.println("方法组B：----");
		one.methodOne();
		three.methodThree();
		four.methodFour();
	}
}
