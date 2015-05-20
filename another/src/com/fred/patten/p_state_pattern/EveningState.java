package com.fred.patten.p_state_pattern;

public class EveningState extends State{

	@Override
	public void writeProgram(Work w) {
		if(w.getTaskFinished()){
			w.setState(new RestState());
			w.writeProgram();
		}else{
			if(w.getHour() < 21){
				System.out.println("当前时间："+w.getHour()+"点,加班，疲劳之际。");
			}else{
				w.setState(new SleepingState());
				w.writeProgram();
			}		
		}
	}

	
}
