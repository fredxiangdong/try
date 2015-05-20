package com.fred.patten.x_repoosibilitychainpattern;

//�ܼ�
public class Majordomo extends Manager{

	public Majordomo(String name){
		super(name);
	}
	
	@Override
	public void requestApplication(Request request) {
		if(request.getRequestType().equals("���")&& request.getNum() <=5){
			System.out.println(name+":"+request.getRequestContent()+"����"+request.getNum()+"����׼");
		}else{
			if(superior != null){
				superior.requestApplication(request);
			}
		}
	}

}