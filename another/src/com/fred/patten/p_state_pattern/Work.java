package com.fred.patten.p_state_pattern;

public class Work {

	protected int hour;
	private State state;
	private Boolean taskFinished;
	
	public Work(){
		state = new ForenoonState();
		taskFinished = false;
	}
	
	public void writeProgram(){
		state.writeProgram(this);
	}
	
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public Boolean getTaskFinished() {
		return taskFinished;
	}

	public void setTaskFinished(Boolean taskFinished) {
		this.taskFinished = taskFinished;
	}
	
}
