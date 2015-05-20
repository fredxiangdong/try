package com.fred.patten.t_iterator_pattern;

public class IteratorPatternTest {
	
	public static void main(String[] args){
		ConcreteAggregate a = new ConcreteAggregate();
		a.setObject(0, "����");
		a.setObject(1, "С��");
		a.setObject(2, "����");
		a.setObject(3, "����");
		a.setObject(4, "�����ڲ�Ա��");
		a.setObject(5, "С͵");
		
		Iterator i = new ConcreteIterator(a);
		while(!i.isDone()){
			System.out.println(i.currentItem()+"����Ʊ��");
			i.next();
		}
	}
}
