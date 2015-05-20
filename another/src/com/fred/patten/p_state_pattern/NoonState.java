package com.fred.patten.p_state_pattern;

public class NoonState extends State{

	@Override
	public void writeProgram(Work w) {
		if(w.getHour() < 13){
			System.out.println("��ǰʱ�䣺"+w.getHour()+"�㣬���ˣ��緹�����������ݡ�");
		}else{
			w.setState(new AfternoonState());
			w.writeProgram();
		}
	}

}
