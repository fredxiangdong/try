package com.fred.trying.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.fred.system.HibernateSessionFactory;
import com.fred.trying.entity.CrmCommunityBuilding;
import com.fred.trying.service.BuildingService;

@Component("buildingService")
public class BuildingServiceImpl implements BuildingService {

	@SuppressWarnings("all")
	public void remove(String Id){
	  // 执行删除操作
		System.out.println("1");
	  if(Id == null){
		return;
	  }
		System.out.println("2");
	  Session session = HibernateSessionFactory.getSessionFactory().openSession();
		System.out.println("3w");
	  session.beginTransaction();
	  System.out.println("2");
	  String hql = "delete from CrmCommunityBuilding where buildingId=?";
	  System.out.println("222");
	  Query query = session.createQuery("delete from CrmCommunityBuilding where buildingId = ? ");
	  System.out.println("2 ");
//	  query.setParameter("Id", Id);
	  query.setString(0, Id);
//	  int rowCount = query.executeUpdate();
//	  System.out.println(rowCount);
	  session.getTransaction().commit();
	 }

	@SuppressWarnings("all")
	public List<CrmCommunityBuilding> retriveAll(String Id) {
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		  session.beginTransaction();
		  // 执行查询操作
		  Query query = session.createQuery("from CrmCommunityBuilding");
		  List<CrmCommunityBuilding> list = query.list();
		  for (CrmCommunityBuilding building : list) {
//			  System.out.println(building.getBuildingId()+building.getBuildingName());
		  }
			return list;
	}

}
