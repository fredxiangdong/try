package com.fred.patten.j_temple_method_pattern;

public class TempleMethodPattern {

	public static void main(String[] args){
		System.out.println("С�����Ծ�");
		TestPaper xiaoming = new TestPaperA();
		xiaoming.TestQuestion1();
		xiaoming.TestQuestion2();
		
		System.out.println("С����Ծ�");
		TestPaper xiaohong = new TestPaperB();
		xiaohong.TestQuestion1();
		xiaohong.TestQuestion2();
	}
}
