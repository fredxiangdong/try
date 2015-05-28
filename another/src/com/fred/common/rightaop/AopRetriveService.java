package com.fred.common.rightaop;

import java.util.List;

import javax.persistence.Query;

public interface AopRetriveService {

	public void preRetrive(String jpql);
	
	public List doRetrive(String jpql,Query query);
}
