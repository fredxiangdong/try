package com.fred.patten.p_state_pattern;

public class SleepingState extends State{

	@Override
	public void writeProgram(Work w) {
		System.out.println("当前时间："+w.getHour()+"点，不行了，睡着了。");
	}
	
}
