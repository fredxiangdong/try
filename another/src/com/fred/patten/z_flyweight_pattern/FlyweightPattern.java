package com.fred.patten.z_flyweight_pattern;

public class FlyweightPattern {
	
	public static void main(String[] args){
		WebsiteFactory f = new WebsiteFactory();
		
		WebSite fx = f.getWebSiteCategory("��Ʒչʾ");
		fx.Use(new User("С��"));
		WebSite fy = f.getWebSiteCategory("��Ʒչʾ");
		fy.Use(new User("����"));
		WebSite fz = f.getWebSiteCategory("��Ʒչʾ");
		fz.Use(new User("����"));
		WebSite f1 = f.getWebSiteCategory("����");
		f1.Use(new User("����ͯ"));
		WebSite f2 = f.getWebSiteCategory("����");
		f2.Use(new User("�ҹ�����"));
		WebSite f3 = f.getWebSiteCategory("����");
		f3.Use(new User("�Ϻ�����"));
		
		System.out.println("��վ��������Ϊ"+f.getWebSiteCount());
	}
}
