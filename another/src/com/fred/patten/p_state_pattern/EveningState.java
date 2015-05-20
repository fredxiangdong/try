package com.fred.patten.p_state_pattern;

public class EveningState extends State{

	@Override
	public void writeProgram(Work w) {
		if(w.getTaskFinished()){
			w.setState(new RestState());
			w.writeProgram();
		}else{
			if(w.getHour() < 21){
				System.out.println("��ǰʱ�䣺"+w.getHour()+"��,�Ӱ࣬ƣ��֮�ʡ�");
			}else{
				w.setState(new SleepingState());
				w.writeProgram();
			}		
		}
	}

	
}
