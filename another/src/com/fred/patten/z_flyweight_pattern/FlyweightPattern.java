package com.fred.patten.z_flyweight_pattern;

public class FlyweightPattern {
	
	public static void main(String[] args){
		WebsiteFactory f = new WebsiteFactory();
		
		WebSite fx = f.getWebSiteCategory("产品展示");
		fx.Use(new User("小菜"));
		WebSite fy = f.getWebSiteCategory("产品展示");
		fy.Use(new User("大鸟"));
		WebSite fz = f.getWebSiteCategory("产品展示");
		fz.Use(new User("娇娇"));
		WebSite f1 = f.getWebSiteCategory("博客");
		f1.Use(new User("老顽童"));
		WebSite f2 = f.getWebSiteCategory("博客");
		f2.Use(new User("桃谷六仙"));
		WebSite f3 = f.getWebSiteCategory("博客");
		f3.Use(new User("南海神尼"));
		
		System.out.println("网站分类总数为"+f.getWebSiteCount());
	}
}
