package com.fred.patten.p_state_pattern;

public class SleepingState extends State{

	@Override
	public void writeProgram(Work w) {
		System.out.println("��ǰʱ�䣺"+w.getHour()+"�㣬�����ˣ�˯���ˡ�");
	}
	
}
