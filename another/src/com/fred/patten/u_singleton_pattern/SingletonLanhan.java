package com.fred.patten.u_singleton_pattern;
/**
 * ����ʽ
 * @author Administrator
 */

//�Ե�һ��static��һЩ����
//java����������һ�������涨�徲̬�ࡣ�����ڲ��ࣨnested class����
//��nested class�������������ⲿ�ࡣ
//��java�У����ǲ�����static���ζ����ࣨtop level class����
//ֻ���ڲ������Ϊstatic��

public class SingletonLanhan {
	//���Լ��ڲ������Լ���һ��
	private static final SingletonLanhan instance = new SingletonLanhan();
	
	private SingletonLanhan(){
		//do something
	}
	
	//�����ṩ��һ�����ⲿ���ʱ�class�ľ�̬����������ֱ�ӷ���
	public static SingletonLanhan getInstance(){
		return instance;
	}
}
