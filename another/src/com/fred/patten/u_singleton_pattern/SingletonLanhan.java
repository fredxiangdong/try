package com.fred.patten.u_singleton_pattern;
/**
 * 懒汉式，也是常用的形式
 * 此例采用了 双重锁的形式。
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
