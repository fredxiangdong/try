package com.fred.patten.z1_interpretre_pattern;

public class InterpreterPatternTest {

	public static void main(String[] args){
		PlayContext context = new PlayContext();
		System.out.println("ÉÏº£Ì²£º");
		context.setText("O 2 E 0.5 G 0.5 A 3 E " +
				"0.5 G 0.5 D 3 E 0.5 G 0.5 A 0.5 O " +
				"3 C 1 O 2 A 0.5 G 1 C 0.5 E 0.5 D 3 ");
		Expression expression = null;
		try{
			while (context.getText().length() > 0)
			{
				String str = context.getText().substring(0, 1);
				switch ((int)str.charAt(0)){
				case (int)'O':
					expression = new Scale();
					break;
				case (int)'C':
				case (int)'D':
				case (int)'E':
				case (int)'F':
				case (int)'G':
				case (int)'A':
				case (int)'B':
				case (int)'P':
					expression = new Note();
					break;
				}
				expression.interpret(context);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
