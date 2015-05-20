package com.fred.patten.x_repoosibilitychainpattern;

//总监
public class Majordomo extends Manager{

	public Majordomo(String name){
		super(name);
	}
	
	@Override
	public void requestApplication(Request request) {
		if(request.getRequestType().equals("请假")&& request.getNum() <=5){
			System.out.println(name+":"+request.getRequestContent()+"数量"+request.getNum()+"被批准");
		}else{
			if(superior != null){
				superior.requestApplication(request);
			}
		}
	}

}