package com.fred.patten.o_abstract_factory;

public class SqlServerFactory implements IFactory{

	public IDepartment createDepartment() {
		return new SqlServerDepartment();
	}

}
