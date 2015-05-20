package com.fred.patten.r_memo_pattern;

public class MemoPatternTest {

	public static void main(String[] args){
		Originator ori = new Originator();
		ori.setState("On");
		ori.show();
		
		Caretaker care = new Caretaker();
		care.setMemo(ori.createMemo());
		
		ori.setState("Off");
		ori.show();
		
		ori.setMemo(care.getMemo());
		ori.show();
	}
}
