package com.fred.patten.z1_interpretre_pattern;

public class Scale extends Expression{

	@Override
	public void execute(String key, Double value) {
		String scale = "";
		switch(value.intValue()){
		case 1:
			scale = "µÕ“Ù";
			break;
		case 2:
			scale = "÷–“Ù";
			break;
		case 3:
			scale = "∏ﬂ“Ù";
			break;
		}
		System.out.println(scale);
	}

}
