package com.fred.patten.t_iterator_pattern;

public interface Iterator {

	public Object first();
	public Object next();
	public Boolean isDone();
	public Object currentItem();
}
