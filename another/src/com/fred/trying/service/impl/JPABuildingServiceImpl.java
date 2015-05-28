package com.fred.trying.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fred.common.HyCommonUtil;
import com.fred.common.UUIDGenerator;
import com.fred.common.rightaop.AopRetriveService;
import com.fred.trying.entity.JPACommunityBuilding;
import com.fred.trying.entity.TbUser;
import com.fred.trying.service.JPABuildingService;
import com.opensymphony.xwork2.ActionContext;

@Component("jPABuildingService")
public class JPABuildingServiceImpl implements JPABuildingService {

	@PersistenceContext(unitName="ebwebPU")
	private EntityManager em;
	
	@Autowired
	private AopRetriveService aopRetriveService;
	
//	@Autowired
//	private JPAUtilService jpaUtil;
	

//这种方式：retrive,但是persist时，数据保存不进数据库
/*	@Autowired
	private EntityManagerFactory emf;*/
	
	
//	这种方式报错：No Persistence provider for EntityManager named ebwebPU
/*	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ebwebPU");
	EntityManager em = emf.createEntityManager();*/
	 
	  //TODO
	public void remove(String Id){

	 }


	@Transactional(propagation = Propagation.REQUIRED,readOnly = true)
	public List<JPACommunityBuilding> retriveAll(String test,int test2) {
		  String jpql = "select build from JPACommunityBuilding build where 1=1";
//		  List<JPACommunityBuilding> buildLs = doRetriveFliter(jpql);
		  //采用hibernate的@Filter方式进行数据过滤
		  List<JPACommunityBuilding> buildLs = doRetriveAop(jpql);
		  //采用spring的AOP切面方式进行数据过滤
		  return buildLs;
	}
	
	@SuppressWarnings("unchecked")
	public List<JPACommunityBuilding> doRetriveAop(String jpql){
		List<JPACommunityBuilding> buildingLs = aopRetriveService.doRetrive(jpql,null);;
		return buildingLs;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED,readOnly = true)
	public List<JPACommunityBuilding> doRetriveFliter(String jpql){
		  List<JPACommunityBuilding> buildLs = new ArrayList<JPACommunityBuilding>();
		  TbUser user = (TbUser)ActionContext.getContext().getSession().get("user");
		  try{
			  //方法上要有@Transactional注解，否则会报session is close异常
			  Session session = (Session)em.getDelegate();
			  //这种方式从entitymanager中得到Session，继而使用session.enableFilter,从而达到过滤数据目的。
			  Filter filter = session.enableFilter("rightFilter");;
			  filter.setParameter("RIGHT_ID", user.getUnitCode());
			  Query query = em.createQuery(jpql);
			  buildLs = query.getResultList();
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		  return buildLs;
	}

	@Transactional(propagation = Propagation.REQUIRED,readOnly=false)
	public JPACommunityBuilding save(JPACommunityBuilding building) {
		if(HyCommonUtil.strIsNull(building.getBuildingId())){
//		if(building.getBuildingId() == null || building.getBuildingId().trim().equals("")){
			UUIDGenerator uuidgen = new UUIDGenerator();
			building.setBuildingId(uuidgen.generate().toString());
			em.persist(building);
		}else{
			em.merge(building);
		}
//		也可两种情况都用merge()方法，merge方法，原来没有的数据进行persist，触发listener的@prepersist，原来有的数据
//		则进行update，触发listener的@preUpdate
		em.merge(building);
		return building;
	}

	@Transactional(propagation = Propagation.REQUIRED ,readOnly = false)
	public void delById(String buildingId) {
		em.remove(em.find(JPACommunityBuilding.class, buildingId));
	}

	@Transactional(propagation = Propagation.REQUIRED ,readOnly = false)
	public JPACommunityBuilding retriveById(String buildingId) {
		return em.find(JPACommunityBuilding.class, buildingId);
	}

}
