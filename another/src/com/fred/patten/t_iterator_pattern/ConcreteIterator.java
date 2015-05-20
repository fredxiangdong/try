package com.fred.patten.t_iterator_pattern;

public class ConcreteIterator implements Iterator{

	private ConcreteAggregate aggregate;
	private int current = 0;
	
	public ConcreteIterator(ConcreteAggregate aggregate){
		this.aggregate = aggregate;
	}

	public Object first() {
		return aggregate.getObject(0);
	}

	public Object next() {
		Object ret = null;
		current++;
		if (current < aggregate.getCount()){
			ret = aggregate.getObject(current);
		}
		return ret;
	}

	public Boolean isDone() {
		return current >= aggregate.getCount() ? true :false;
	}

	public Object currentItem() {
		return aggregate.getObject(current);
	}
	
}
