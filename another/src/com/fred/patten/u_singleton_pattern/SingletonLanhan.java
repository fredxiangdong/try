package com.fred.patten.u_singleton_pattern;
/**
 * 饿汉式
 * @author Administrator
 */

//对第一行static的一些解释
//java允许我们在一个类里面定义静态类。比如内部类（nested class）。
//把nested class封闭起来的类叫外部类。
//在java中，我们不能用static修饰顶级类（top level class）。
//只有内部类可以为static。

public class SingletonLanhan {
	//在自己内部定义自己的一个
	private static final SingletonLanhan instance = new SingletonLanhan();
	
	private SingletonLanhan(){
		//do something
	}
	
	//这里提供了一个供外部访问本class的静态方法，可以直接访问
	public static SingletonLanhan getInstance(){
		return instance;
	}
}
