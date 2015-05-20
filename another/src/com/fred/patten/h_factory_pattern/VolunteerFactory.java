package com.fred.patten.h_factory_pattern;

public class VolunteerFactory extends IFactory{

	@Override
	public Leifeng createLeifeng() {
		return new Volunteer();
	}

}
