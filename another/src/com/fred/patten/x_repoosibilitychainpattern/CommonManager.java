package com.fred.patten.x_repoosibilitychainpattern;

//����
public class CommonManager extends Manager{

	public CommonManager(String name){
		super(name);
	}
	
	@Override
	public void requestApplication(Request request) {
		if(request.getRequestType().equals("���")&& request.getNum() <=2){
			System.out.println(name+":"+request.getRequestContent()+"����"+request.getNum()+"����׼");
		}else{
			if(superior != null){
				superior.requestApplication(request);
			}
		}
	}

}
