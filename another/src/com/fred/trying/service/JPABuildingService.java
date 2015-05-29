package com.fred.trying.service;

import java.util.List;

import com.fred.trying.entity.JPACommunityBuilding;

public interface JPABuildingService {
	
	/**
	 * ��ѯȫ����Ϣ
	 * @return
	 */
	public List<JPACommunityBuilding> retriveAll();
	
	/**
	 * ����
	 * @param building
	 */
	public JPACommunityBuilding save(JPACommunityBuilding building);
	
	/**
	 * ɾ��
	 * @param buildingId
	 */
	public void delById(String buildingId);
	
	/**
	 * ��ȡָ��ID��building����
	 * @param buildingId
	 */
	public JPACommunityBuilding retriveById(String buildingId);
	
	public List<JPACommunityBuilding> doRetriveAop(String jpql);
	
}
