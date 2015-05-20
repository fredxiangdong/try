package com.fred.patten.x_repoosibilitychainpattern;

public class ReponsibilityChainTest {

	public static void main(String[] args){
		CommonManager jinli = new CommonManager("����");
		Majordomo zongjian = new Majordomo("�ڽ�");
		GeneralManager zhongjingli = new GeneralManager("�Ӿ���");
		jinli.setSuperior(zongjian);
		zongjian.setSuperior(zhongjingli);
		
		Request request = new Request();
		request.setRequestType("���");
		request.setRequestContent("С�����");
		request.setNum(1);
		jinli.requestApplication(request);
		
		Request request2 = new Request();
		request2.setRequestType("���");
		request2.setRequestContent("С�����");
		request2.setNum(4);
		jinli.requestApplication(request2);
		
		Request request3 = new Request();
		request3.setRequestType("��н");
		request3.setRequestContent("С���������");
		request3.setNum(400);
		jinli.requestApplication(request3);
		
		Request request4 = new Request();
		request4.setRequestType("��н");
		request4.setRequestContent("С���������");
		request4.setNum(1000);
		jinli.requestApplication(request4);
		
		Request request5 = new Request();
		request5.setRequestType("���");
		request5.setRequestContent("С�����");
		request5.setNum(8);
		jinli.requestApplication(request5);
	}
}
