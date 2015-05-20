package com.fred.patten.s_composite_pattern;

public class CompositePatternTest {

	public static void main(String[] args){
		ConcreteCompany root = new ConcreteCompany("�����ܹ�˾");
		root.Add(new HRDepartment("�ܹ�˾������Դ��"));
		root.Add(new FinanceDepartment("�ܹ�˾����"));
		
		ConcreteCompany comp1 = new ConcreteCompany("�����ֹ�˾");
		comp1.Add(new HRDepartment("�����ֹ�˾������Դ��"));
		comp1.Add(new FinanceDepartment("�����ֹ�˾����"));
		root.Add(comp1);
		
		ConcreteCompany comp2 = new ConcreteCompany("�Ͼ����´�");
		comp2.Add(new HRDepartment("�Ͼ����´�������Դ��"));
		comp2.Add(new FinanceDepartment("�Ͼ����´�����"));
		comp1.Add(comp2);
		
		ConcreteCompany comp3 = new ConcreteCompany("���ݰ��´�");
		comp3.Add(new HRDepartment("���ݰ��´�������Դ��"));
		comp3.Add(new FinanceDepartment("���ݰ��´�����"));
		comp1.Add(comp3);
	
		System.out.println("�ṹͼ:");
		root.Display(1);
		
		System.out.println("ְ��:");
		root.LineOfDuty();
	}
}
