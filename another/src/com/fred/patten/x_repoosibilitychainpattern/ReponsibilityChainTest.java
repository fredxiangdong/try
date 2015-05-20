package com.fred.patten.x_repoosibilitychainpattern;

public class ReponsibilityChainTest {

	public static void main(String[] args){
		CommonManager jinli = new CommonManager("½ðÀû");
		Majordomo zongjian = new Majordomo("×Ú½£");
		GeneralManager zhongjingli = new GeneralManager("ÖÓ¾«Àø");
		jinli.setSuperior(zongjian);
		zongjian.setSuperior(zhongjingli);
		
		Request request = new Request();
		request.setRequestType("Çë¼Ù");
		request.setRequestContent("Ð¡²ËÇë¼Ù");
		request.setNum(1);
		jinli.requestApplication(request);
		
		Request request2 = new Request();
		request2.setRequestType("Çë¼Ù");
		request2.setRequestContent("Ð¡²ËÇë¼Ù");
		request2.setNum(4);
		jinli.requestApplication(request2);
		
		Request request3 = new Request();
		request3.setRequestType("¼ÓÐ½");
		request3.setRequestContent("Ð¡²ËÇëÇóÇë¼Ù");
		request3.setNum(400);
		jinli.requestApplication(request3);
		
		Request request4 = new Request();
		request4.setRequestType("¼ÓÐ½");
		request4.setRequestContent("Ð¡²ËÇëÇóÇë¼Ù");
		request4.setNum(1000);
		jinli.requestApplication(request4);
		
		Request request5 = new Request();
		request5.setRequestType("Çë¼Ù");
		request5.setRequestContent("Ð¡²ËÇë¼Ù");
		request5.setNum(8);
		jinli.requestApplication(request5);
	}
}
