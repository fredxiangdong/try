package com.fred.patten.p_state_pattern;

public class ForenoonState extends State{

	@Override
	public void writeProgram(Work w) {
		if(w.getHour() < 12){
			System.out.println("��ǰʱ��"+w.hour+"�㣬���繤���������棡");
		}else{
			w.setState(new NoonState());
			w.writeProgram();
		}
	}
	
}
