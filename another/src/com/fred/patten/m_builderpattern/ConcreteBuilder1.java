package com.fred.patten.m_builderpattern;

public class ConcreteBuilder1 implements Builder{

	private Product product = new Product();
	public void buildPartA() {
		product.add("部件A");
	}

	public void buildPartB() {
		product.add("部件B");
	}

	public Product getResult() {
		return product;
	}

}
