package com.fred.patten.m_builderpattern;

public class ConcreteBuilder2 implements Builder{

	private Product product = new Product();
	public void buildPartA() {
		product.add("部件X");
	}

	public void buildPartB() {
		product.add("部件Y");
	}

	public Product getResult() {
		return product;
	}
}
