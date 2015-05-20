package com.fred.patten.m_builderpattern;

public class ConcreteBuilder1 implements Builder{

	private Product product = new Product();
	public void buildPartA() {
		product.add("����A");
	}

	public void buildPartB() {
		product.add("����B");
	}

	public Product getResult() {
		return product;
	}

}
