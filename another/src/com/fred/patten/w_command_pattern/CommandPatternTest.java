package com.fred.patten.w_command_pattern;

public class CommandPatternTest {

	public static void main(String[] args){
		Receiver r = new Receiver();
		Command c = new ConcreteCommand(r);
		Invoker i = new Invoker();
		
		i.setCommand(c);
		i.excuteCommand();
	}
}
