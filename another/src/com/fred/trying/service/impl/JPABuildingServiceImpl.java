package com.fred.trying.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fred.trying.entity.JPACommunityBuilding;
import com.fred.trying.service.JPABuildingService;

@Component("jPABuildingService")
public class JPABuildingServiceImpl implements JPABuildingService {

//	@PersistenceContext(unitName="ebwebPU")
//	private EntityManager em;
//  二者选一个即可
	
	@Autowired
	private EntityManagerFactory emf;
	 
	  //TODO
	public void remove(String Id){

	 }


//	@SuppressWarnings("all")
	public List<JPACommunityBuilding> retriveAll() {
		  String jpql = "select build from JPACommunityBuilding build where 1=1";
		  EntityManager em = emf.createEntityManager();
		  List<JPACommunityBuilding> buildLs = new ArrayList<JPACommunityBuilding>();
		  try{
			  Query query = em.createQuery(jpql);
			  buildLs = query.getResultList();
		  }catch(Exception e){
			  e.printStackTrace();
		  }
			return buildLs;
	}

}
