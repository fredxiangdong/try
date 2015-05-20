package com.fred.patten.o_abstract_factory;

public class AccessDepartment implements IDepartment{

	public void insert(Department department) {
		System.out.println("在Access中给Department表添加一条记录");
	}

	public Department getDepartment(int id) {
		System.out.println("在Access中根据ID得到Department表一条记录");
		return null;
	}


	
}
