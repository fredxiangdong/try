package com.fred.patten.o_abstract_factory;

public class AccessDepartment implements IDepartment{

	public void insert(Department department) {
		System.out.println("��Access�и�Department�����һ����¼");
	}

	public Department getDepartment(int id) {
		System.out.println("��Access�и���ID�õ�Department��һ����¼");
		return null;
	}


	
}
