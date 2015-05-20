package com.fred.patten.x_repoosibilitychainpattern;

//经理
public class CommonManager extends Manager{

	public CommonManager(String name){
		super(name);
	}
	
	@Override
	public void requestApplication(Request request) {
		if(request.getRequestType().equals("请假")&& request.getNum() <=2){
			System.out.println(name+":"+request.getRequestContent()+"数量"+request.getNum()+"被批准");
		}else{
			if(superior != null){
				superior.requestApplication(request);
			}
		}
	}

}
