package com.fred.patten.s_composite_pattern;

import java.util.ArrayList;
import java.util.List;

public class ConcreteCompany extends Company{

	private List<Company> children = new ArrayList<Company>();
	
	public ConcreteCompany(String name){
		super(name);
	}
	
	@Override
	public void Add(Company c) {
		children.add(c);
	}

	@Override
	public void Remove(Company c) {
		children.remove(c);
	}

	@Override
	public void Display(int depth) {
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= depth; i++){
			sb.append("-");
		}
		System.out.println(sb.toString()+name);
		
		for(Company com : children){
			com.Display(depth + 2);
		}
	}

	@Override
	public void LineOfDuty() {
		for(Company com : children){
			com.LineOfDuty();
		}
	}

}
