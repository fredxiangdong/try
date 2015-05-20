package com.fred.patten.u_singleton_pattern;
/**
 * ����ʽ��Ҳ�ǳ��õ���ʽ
 * ���������� ˫��������ʽ��
 * @author Administrator
 *
 */
public class SingletonEhan {
	
	private static SingletonEhan instance = null;
	
	public static SingletonEhan getInstance(){
		if(instance == null){
			synchronized(SingletonEhan.class)
			{
				if(instance == null){
					instance = new SingletonEhan();
				}
			}
		}
		return instance;
	}
	
	private SingletonEhan(){}
	
}
