package com.fred.patten.o_abstract_factory;

public class AccessFactory implements IFactory{

	public IDepartment createDepartment() {
		return new AccessDepartment();
	}

}
