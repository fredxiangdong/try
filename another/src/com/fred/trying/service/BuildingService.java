package com.fred.trying.service;

import java.util.List;

import com.fred.trying.entity.CrmCommunityBuilding;
import com.fred.trying.entity.JPACommunityBuilding;

public interface BuildingService {
	/**
	 * ��ѯָ����Ϣ
	 * @param Id
	 * @return
	 */
	public List<CrmCommunityBuilding> retriveAll(String Id);
	/**
	 * ɾ��
	 * @param Id
	 */
	public void remove(String Id);
	
}
