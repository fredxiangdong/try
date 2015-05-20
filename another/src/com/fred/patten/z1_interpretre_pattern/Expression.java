package com.fred.patten.z1_interpretre_pattern;

public class Expression {
	
	public void interpret(PlayContext context){
		if(context.getText().length() == 0){
			return;
		}else{
			String playKey = context.getText().substring(0,1);
			context.setText(context.getText().substring(2));
			Double playValue = Double.parseDouble
					(context.getText().substring(0,context.getText().indexOf(" ")));
			context.setText(context.getText().substring(context.getText().indexOf(" ")+1));
			
			execute(playKey,playValue);
		}
	}
	
	public void execute(String key, Double value){};
}
