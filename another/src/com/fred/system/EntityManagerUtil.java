package com.fred.system;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EntityManagerUtil {

	@PersistenceContext(unitName ="ebwebPU")
	public static EntityManager em; 
	
}
