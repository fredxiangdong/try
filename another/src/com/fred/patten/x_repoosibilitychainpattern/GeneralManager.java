package com.fred.patten.x_repoosibilitychainpattern;

public class GeneralManager extends Manager{

	public GeneralManager(String name){
		super(name);
	}
	
	@Override
	public void requestApplication(Request request) {
		if(request.getRequestType().equals("���")){
			System.out.println(name+":"+request.getRequestContent()+"����"+request.getNum()+"����׼");
		}else if(request.getRequestType().equals("��н") && request.getNum() <= 500){
			System.out.println(name+":"+request.getRequestContent()+"����"+request.getNum()+"����׼");
		}else if(request.getRequestType().equals("��н") && request.getNum() > 500){
			System.out.println(name+":"+request.getRequestContent()+"����"+request.getNum()+"��˵��");
		}
	}

}
