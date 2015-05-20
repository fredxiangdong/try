package com.fred.patten.r_memo_pattern;

public class Originator {

	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public Memo createMemo(){
		return new Memo(state);
	}
	
	public void setMemo(Memo memo){
		state = memo.getState();
	}
	
	public void show(){
		System.out.println("State="+state);
	}
}
