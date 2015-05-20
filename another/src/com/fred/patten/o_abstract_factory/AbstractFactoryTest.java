package com.fred.patten.o_abstract_factory;

public class AbstractFactoryTest {

	public static void main(String[] args){
		Department dept = new Department();
		
//		IFactory factory = new SqlServerFactory();
		IFactory factory = new AccessFactory();
		
		IDepartment id = factory.createDepartment();
		id.insert(dept);
		id.getDepartment(1);
	}
}
