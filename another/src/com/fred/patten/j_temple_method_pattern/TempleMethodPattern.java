package com.fred.patten.j_temple_method_pattern;

public class TempleMethodPattern {

	public static void main(String[] args){
		System.out.println("小明的试卷：");
		TestPaper xiaoming = new TestPaperA();
		xiaoming.TestQuestion1();
		xiaoming.TestQuestion2();
		
		System.out.println("小红的试卷：");
		TestPaper xiaohong = new TestPaperB();
		xiaohong.TestQuestion1();
		xiaohong.TestQuestion2();
	}
}
