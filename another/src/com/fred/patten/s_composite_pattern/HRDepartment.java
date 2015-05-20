package com.fred.patten.s_composite_pattern;

public class HRDepartment extends Company{

	public HRDepartment(String name){
		super(name);
	}
	
	@Override
	public void Add(Company c) {
	}

	@Override
	public void Remove(Company c) {
	}

	@Override
	public void Display(int depth) {
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= depth; i++){
			sb.append("-");
		}
		System.out.println(sb.toString()+name);
	}

	@Override
	public void LineOfDuty() {
		System.out.println(name+"员工招聘培训管理");
	}

}
