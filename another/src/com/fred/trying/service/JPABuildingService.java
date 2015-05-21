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
	 * ɾ��
	 * @param Id
	 */
	public void remove(String Id);
	
	/**
	 * ����
	 * @param building
	 */
	public JPACommunityBuilding save(JPACommunityBuilding building);
}
