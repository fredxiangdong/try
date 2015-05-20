package com.fred.patten.p_state_pattern;

public class StatePatternTest {

	public static void main(String[] args){
		Work emergencyProject = new Work();
		emergencyProject.setHour(9);
		emergencyProject.writeProgram();
		emergencyProject.setHour(10);
		emergencyProject.writeProgram();
		emergencyProject.setHour(12);
		emergencyProject.writeProgram();
		emergencyProject.setHour(13);
		emergencyProject.writeProgram();
		emergencyProject.setHour(15);
		emergencyProject.writeProgram();

//		emergencyProject.setTaskFinished(true);
		emergencyProject.setTaskFinished(false);
	
		emergencyProject.setHour(19);
		emergencyProject.writeProgram();
		emergencyProject.setHour(22);
		emergencyProject.writeProgram();
	}
}
