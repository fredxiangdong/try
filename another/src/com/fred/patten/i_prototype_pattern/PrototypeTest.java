package com.fred.patten.i_prototype_pattern;

import java.lang.reflect.InvocationTargetException;

public class PrototypeTest {

	public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException{
		Resume a = new Resume("大鸟");
		a.setPersonalInfo("男", "29");
		a.setWorkExperience("1998-2000", "XX公司");
		
		Resume b = a.clone();
		b.setWorkExperience("2000-2006", "XY公司");
		
		Resume c = a.clone();
		c.setWorkExperience("2006-2014", "YY公司");
		
		a.display();
		b.display();
		c.display();
	}
}
