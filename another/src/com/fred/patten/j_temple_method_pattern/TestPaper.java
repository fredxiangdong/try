package com.fred.patten.j_temple_method_pattern;

public abstract class TestPaper {

	public void TestQuestion1(){
		System.out.println("杨过得到，后来给了郭靖，练成倚天剑、屠龙刀" +
				"的玄铁可能是【】 a、球磨铸铁 b、马口铁 c、高速合金钢 d、碳素纤维");
		System.out.println("答案为："+ Answer1());
		
	}
	
	public void TestQuestion2(){
		System.out.println("杨过、程英、陆无双铲除了情花，造成【】 a、这种植物不再害人" +
				" b、使一种珍稀物种灭绝 c、破坏了那个生物圈的生态平衡 d、造成该地区沙漠化");
		System.out.println("答案为："+ Answer2());
	}
	
	public abstract String Answer1();
	
	public abstract String Answer2();
}
