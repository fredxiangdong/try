package com.fred.patten.p_state_pattern;

public class AfternoonState extends State{

	@Override
	public void writeProgram(Work w) {
		if(w.getHour() < 17){
			System.out.println("��ǰʱ�䣺"+w.getHour()+"�㣬����״̬����������Ŭ����");
		}else{
			w.setState(new EveningState());
			w.writeProgram();
		}
	}
	
}
