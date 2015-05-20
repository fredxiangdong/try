package com.fred.patten.z1_interpretre_pattern;

public class Note extends Expression{

	@Override
	public void execute(String key, Double value) {
		String note = "";
		switch((int)key.toCharArray()[0]){
			case (int)'C':{
				note = "1";
				break;
			}
			case (int)'D':{
				note = "2";
				break;
			}
			case (int)'E':{
				note = "3";
				break;
			}
			case (int)'F':{
				note = "4";
				break;
			}
			case (int)'G':{
				note = "5";
				break;
			}
			case (int)'A':{
				note = "6";
				break;
			}
			case (int)'B':{
				note = "7";
				break;
			}
		}
		System.out.println(note);
	}

}
