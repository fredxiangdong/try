package com.fred.patten.i_prototype_pattern;

import java.lang.reflect.InvocationTargetException;

public class PrototypeTest {

	public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException{
		Resume a = new Resume("����");
		a.setPersonalInfo("��", "29");
		a.setWorkExperience("1998-2000", "XX��˾");
		
		Resume b = a.clone();
		b.setWorkExperience("2000-2006", "XY��˾");
		
		Resume c = a.clone();
		c.setWorkExperience("2006-2014", "YY��˾");
		
		a.display();
		b.display();
		c.display();
	}
}
