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
	  if(Id == null){
		return;
	  }
	  Session session = HibernateSessionFactory.getSessionFactory().openSession();
	  session.beginTransaction();
	  String hql = "delete from CrmCommunityBuilding where buildingId=?";
	  Query query = session.createQuery("delete from CrmCommunityBuilding where buildingId = ? ");
//	  query.setParameter("Id", Id);
	  query.setString(0, Id);
//	  int rowCount = query.executeUpdate();
	  session.getTransaction().commit();
	 }

	@SuppressWarnings("all")
	public List<CrmCommunityBuilding> retriveAll(String Id) {
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		//Ö´ÐÐ²éÑ¯²Ù×÷
		Query query = session.createQuery("from CrmCommunityBuilding");
		List<CrmCommunityBuilding> list = query.list();
		for (CrmCommunityBuilding building : list) {
			//System.out.println(building.getBuildingId()+building.getBuildingName());
		}
		return list;
	}

}
