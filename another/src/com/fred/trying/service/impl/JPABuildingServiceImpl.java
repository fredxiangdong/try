package com.fred.trying.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fred.common.UUIDGenerator;
import com.fred.trying.entity.JPACommunityBuilding;
import com.fred.trying.service.JPABuildingService;

@Component("jPABuildingService")
public class JPABuildingServiceImpl implements JPABuildingService {

	@PersistenceContext(unitName="ebwebPU")
	private EntityManager em;

//这种方式：retrive,但是persist时，数据保存不进数据库
/*	@Autowired
	private EntityManagerFactory emf;*/
	
	
//	这种方式报错：No Persistence provider for EntityManager named ebwebPU
/*	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ebwebPU");
	EntityManager em = emf.createEntityManager();*/
	 
	  //TODO
	public void remove(String Id){

	 }


//	@SuppressWarnings("all")
	public List<JPACommunityBuilding> retriveAll() {
		  String jpql = "select build from JPACommunityBuilding build where 1=1";
		  List<JPACommunityBuilding> buildLs = new ArrayList<JPACommunityBuilding>();
		  try{
			  Query query = em.createQuery(jpql);
			  buildLs = query.getResultList();
		  }catch(Exception e){
			  e.printStackTrace();
		  }
			return buildLs;
	}

	@Transactional(propagation = Propagation.REQUIRED,readOnly=false)
	public JPACommunityBuilding save(JPACommunityBuilding building) {
		if(building.getBuildingId() == null){
			UUIDGenerator uuidgen = new UUIDGenerator();
			building.setBuildingId(uuidgen.generate().toString());
		}
		em.persist(building);
		return building;
	}


}
