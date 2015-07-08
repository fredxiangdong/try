package com.fred.common.baseaction;

import java.lang.reflect.ParameterizedType;

import com.fred.trying.entity.TbUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	public T model;
	private static final long serialVersionUID = 1L;

	// modelDriven��֧��
	// ʹ��modelDriven֮�󣬿����ڶ���ջ��ֱ��ȡ��model����
	public BaseAction() {
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
		try {
			model = clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ��ȡ��ǰ��½���û�
	protected TbUser getCurrentUser() {
		return (TbUser) ActionContext.getContext().getSession().get("user");
	}

	public T getModel() {// ʵ����modeldriven�ӿڣ���role����push���˶���ջ
		return model;
	}

}
