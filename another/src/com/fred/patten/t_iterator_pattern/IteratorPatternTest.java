package com.fred.patten.t_iterator_pattern;

public class IteratorPatternTest {
	
	public static void main(String[] args){
		ConcreteAggregate a = new ConcreteAggregate();
		a.setObject(0, "大鸟");
		a.setObject(1, "小菜");
		a.setObject(2, "行李");
		a.setObject(3, "老外");
		a.setObject(4, "公交内部员工");
		a.setObject(5, "小偷");
		
		Iterator i = new ConcreteIterator(a);
		while(!i.isDone()){
			System.out.println(i.currentItem()+"请买车票。");
			i.next();
		}
	}
}
