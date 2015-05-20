package com.fred.patten.x_repoosibilitychainpattern;

public class GeneralManager extends Manager{

	public GeneralManager(String name){
		super(name);
	}
	
	@Override
	public void requestApplication(Request request) {
		if(request.getRequestType().equals("请假")){
			System.out.println(name+":"+request.getRequestContent()+"数量"+request.getNum()+"被批准");
		}else if(request.getRequestType().equals("加薪") && request.getNum() <= 500){
			System.out.println(name+":"+request.getRequestContent()+"数量"+request.getNum()+"被批准");
		}else if(request.getRequestType().equals("加薪") && request.getNum() > 500){
			System.out.println(name+":"+request.getRequestContent()+"数量"+request.getNum()+"再说吧");
		}
	}

}
