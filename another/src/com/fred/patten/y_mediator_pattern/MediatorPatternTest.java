package com.fred.patten.y_mediator_pattern;

public class MediatorPatternTest {

	public static void main(String[] args){
		UnitedNationsSecurityCouncil UNSC = new UnitedNationsSecurityCouncil();
		
		USA c1 = new USA(UNSC);
		Iraq c2 = new Iraq(UNSC);
		
		UNSC.setColleague1(c1);
		UNSC.setColleague2(c2);
		
		c1.Declare("��׼���ƺ�����������Ҫ����ս��");
		c2.Declare("����û�к�������Ҳ��������");
	}
}
