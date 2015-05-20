package com.fred.patten.p_state_pattern;

public class ForenoonState extends State{

	@Override
	public void writeProgram(Work w) {
		if(w.getHour() < 12){
			System.out.println("当前时间"+w.hour+"点，上午工作精力充沛！");
		}else{
			w.setState(new NoonState());
			w.writeProgram();
		}
	}
	
}
