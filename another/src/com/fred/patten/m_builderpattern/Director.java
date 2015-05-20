package com.fred.patten.m_builderpattern;

public class Director {

	public void Construct(Builder builder){
		builder.buildPartA();
		builder.buildPartB();
	}
}
