package com.fred.patten.j_temple_method_pattern;

public abstract class TestPaper {

	public void TestQuestion1(){
		System.out.println("����õ����������˹������������콣��������" +
				"�����������ǡ��� a����ĥ���� b������� c�����ٺϽ�� d��̼����ά");
		System.out.println("��Ϊ��"+ Answer1());
		
	}
	
	public void TestQuestion2(){
		System.out.println("�������Ӣ��½��˫�������黨����ɡ��� a������ֲ�ﲻ�ٺ���" +
				" b��ʹһ����ϡ������� c���ƻ����Ǹ�����Ȧ����̬ƽ�� d����ɸõ���ɳĮ��");
		System.out.println("��Ϊ��"+ Answer2());
	}
	
	public abstract String Answer1();
	
	public abstract String Answer2();
}
