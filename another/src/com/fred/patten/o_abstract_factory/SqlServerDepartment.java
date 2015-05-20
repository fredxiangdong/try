package com.fred.patten.o_abstract_factory;

public class SqlServerDepartment implements IDepartment{

	public void insert(Department department) {
		System.out.println("在SQL Server中给Department表添加一条记录");
	}

	public Department getDepartment(int id) {
		System.out.println("在SQL Server中根据ID得到Department表一条记录");
		return null;
	}

	
}
