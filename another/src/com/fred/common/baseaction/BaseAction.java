package com.fred.common.baseaction;

import java.lang.reflect.ParameterizedType;

import com.fred.trying.entity.TbUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	public T model;
	private static final long serialVersionUID = 1L;

	// modelDriven的支持
	// 使用modelDriven之后，可以在对象栈中直接取到model对象。
	public BaseAction() {
		ParameterizedType pt = (ParameterizedType) this.getClass()//Class字节码
				.getGenericSuperclass(); //因为对于T.class我们无法获取，但是这个方法就能获取到父类的参数类型，返回值为ParameterizedType
		Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];//数组里第一个就是子类继承父类时所用类型
		try {
			model = clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 获取当前登陆的用户
	protected TbUser getCurrentUser() {
		return (TbUser) ActionContext.getContext().getSession().get("user");
	}

	public T getModel() {// 实现了modeldriven接口，将role对象push到了对象栈
		return model;
	}

}
