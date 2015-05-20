package com.fred.patten.w_command_pattern;

public class Invoker {

	private Command command;
	
	public void setCommand(Command command){
		this.command = command;
	}
	
	public void excuteCommand(){
		command.execute();
	}
}
