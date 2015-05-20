package com.fred.patten.h_factory_pattern;

public class UndergraduateFactory extends IFactory{

	public Leifeng createLeifeng() {
		return new Undergraduate();
	}

}
