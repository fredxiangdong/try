package com.fred.patten.u_singleton_pattern;
/**
 * ����ʽ��Ҳ�ǳ��õ���ʽ
 * ���������� ˫��������ʽ��
 * @author Administrator
 *
 */
public class SingletonLanhan {
	
	private static SingletonLanhan instance = null;
	
	public static SingletonLanhan getInstance(){
		if(instance == null){
			synchronized(SingletonLanhan.class)
			{
				if(instance == null){
					instance = new SingletonLanhan();
				}
			}
		}
		return instance;
	}
	
	private SingletonLanhan(){}
	
}
