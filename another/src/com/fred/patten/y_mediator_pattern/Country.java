package com.fred.patten.y_mediator_pattern;

public abstract class Country {

	protected UnitedNations mediator;
	
	public Country(UnitedNations mediator){
		this.mediator = mediator;
	}
}
