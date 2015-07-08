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
import com.fred.common.sysmodel.PageInfo;
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
	
//���ַ�ʽ��retrive,����persistʱ�����ݱ��治�����ݿ�
/*	@Autowired
	private EntityManagerFactory emf;*/
	
	
//	���ַ�ʽ����No Persistence provider for EntityManager named ebwebPU
/*	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ebwebPU");
	EntityManager em = emf.createEntityManager();*/
	 

	@Transactional(propagation = Propagation.REQUIRED,readOnly = true)
	public List<JPACommunityBuilding> retriveAll(PageInfo pageInfo) {
		  String jpql = "select build from JPACommunityBuilding build where 1=1";
		  List<JPACommunityBuilding> buildLs = doRetriveFliter(jpql,pageInfo);
		  //����hibernate��@Filter��ʽ�������ݹ���
//		  List<JPACommunityBuilding> buildLs = doRetriveAop(jpql);
		  //����spring��AOP���淽ʽ�������ݹ���
		  return buildLs;
	}
	
	@SuppressWarnings("unchecked")
	public List<JPACommunityBuilding> doRetriveAop(String jpql){
		List<JPACommunityBuilding> buildingLs = aopRetriveService.doRetrive(jpql,null);;
		return buildingLs;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED,readOnly = true)
	public List<JPACommunityBuilding> doRetriveFliter(String jpql,PageInfo pageInfo){
		  List<JPACommunityBuilding> buildLs = new ArrayList<JPACommunityBuilding>();
		  TbUser user = (TbUser)ActionContext.getContext().getSession().get("user");
		  try{
			  //������Ҫ��@Transactionalע�⣬����ᱨsession is close�쳣
			  Session session = (Session)em.getDelegate();
			  //���ַ�ʽ��entitymanager�еõ�Session���̶�ʹ��session.enableFilter,�Ӷ��ﵽ��������Ŀ�ġ�
			  Filter filter = session.enableFilter("rightFilter");;
			  filter.setParameter("RIGHT_ID", user.getUnitCode());
			  Query query = em.createQuery(jpql);
			  query.setFirstResult(pageInfo.getCurPageNum()*pageInfo.getRowOfPage());//��ǰҳ��
			  query.setMaxResults(pageInfo.getRowOfPage());//ÿҳ����
			  buildLs = query.getResultList();
			  int rowNum = Integer.valueOf(em.createQuery("select count(*) from JPACommunityBuilding").getSingleResult().toString());
			  pageInfo.setAllRowNum(rowNum);
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		  return buildLs;
	}

	@Transactional(propagation = Propagation.REQUIRED,readOnly=false)
	public JPACommunityBuilding save(JPACommunityBuilding building) {
		if(HyCommonUtil.strIsNull(building.getBuildingId())){
			if(HyCommonUtil.strIsNull(building.getUnitCode())){
				building.setUnitCode("1");
			}
			//UUIDGenerator uuiden = new UUIDGenerator();
			//�������ɸ�Ϊ��̬����
			building.setBuildingId(UUIDGenerator.generate().toString());
			em.persist(building);
		}else{
			em.merge(building);
		}
//		Ҳ�������������merge()������merge������ԭ��û�е����ݽ���persist������listener��@prepersist��ԭ���е�����
//		�����update������listener��@preUpdate
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
