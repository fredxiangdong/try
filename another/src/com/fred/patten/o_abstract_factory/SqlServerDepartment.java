package com.fred.patten.o_abstract_factory;

public class SqlServerDepartment implements IDepartment{

	public void insert(Department department) {
		System.out.println("��SQL Server�и�Department�����һ����¼");
	}

	public Department getDepartment(int id) {
		System.out.println("��SQL Server�и���ID�õ�Department��һ����¼");
		return null;
	}

	
}
