package com.fred.patten.t_iterator_pattern;

import java.util.ArrayList;
import java.util.List;

public class ConcreteAggregate implements Aggregate{

	private List<Object> items = new ArrayList<Object>();
	
	public Iterator createIterator() {
		return new ConcreteIterator(this);
	}
	
	public int getCount(){
		return items.size();
	}

	public Object getObject(int index){
		return items.get(index);
	}
	
	public void setObject(int index, Object obj){
		items.add(index, obj);
	}
}
