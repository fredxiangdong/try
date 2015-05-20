package com.fred.patten.u_singleton_pattern;
/**
 * 懒汉式，也是常用的形式
 * 此例采用了 双重锁的形式。
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
