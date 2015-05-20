package com.fred.patten.s_composite_pattern;

public class CompositePatternTest {

	public static void main(String[] args){
		ConcreteCompany root = new ConcreteCompany("北京总公司");
		root.Add(new HRDepartment("总公司人力资源部"));
		root.Add(new FinanceDepartment("总公司财务部"));
		
		ConcreteCompany comp1 = new ConcreteCompany("华东分公司");
		comp1.Add(new HRDepartment("华东分公司人力资源部"));
		comp1.Add(new FinanceDepartment("华东分公司财务部"));
		root.Add(comp1);
		
		ConcreteCompany comp2 = new ConcreteCompany("南京办事处");
		comp2.Add(new HRDepartment("南京办事处人力资源部"));
		comp2.Add(new FinanceDepartment("南京办事处财务部"));
		comp1.Add(comp2);
		
		ConcreteCompany comp3 = new ConcreteCompany("杭州办事处");
		comp3.Add(new HRDepartment("杭州办事处人力资源部"));
		comp3.Add(new FinanceDepartment("杭州办事处财务部"));
		comp1.Add(comp3);
	
		System.out.println("结构图:");
		root.Display(1);
		
		System.out.println("职责:");
		root.LineOfDuty();
	}
}
