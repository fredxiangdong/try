package com.fred.common.rightaop;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

@Component("aopRetriveService")
public class AopRetriveServiceImpl implements AopRetriveService{

	public void preRetrive(String jpql) {
		System.out.println(jpql);
	}
	
	public List<Object> doRetrive(String jpql,Query query) {
		List<Object> retLs= query.getResultList();
		return retLs;
	}

}
