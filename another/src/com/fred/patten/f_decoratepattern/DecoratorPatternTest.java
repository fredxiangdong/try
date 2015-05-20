package com.fred.patten.f_decoratepattern;

public class DecoratorPatternTest {
	
	public static void main(String[] args){
		Person per = new Person("fred");
		System.out.println("��һ��װ�磺");
		
		Sneaker sneaker = new Sneaker();
		BigTrouser bigTrouser = new BigTrouser();
		Tshirts tShirt = new Tshirts();
		
		sneaker.Decorate(per);
		bigTrouser.Decorate(sneaker);
		tShirt.Decorate(bigTrouser);
		tShirt.show();
	}
}
