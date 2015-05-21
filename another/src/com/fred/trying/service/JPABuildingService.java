package com.fred.trying.service;

import java.util.List;

import com.fred.trying.entity.JPACommunityBuilding;

public interface JPABuildingService {
	
	/**
	 * 查询全部信息
	 * @return
	 */
	public List<JPACommunityBuilding> retriveAll();
	
	/**
	 * 删除
	 * @param Id
	 */
	public void remove(String Id);
	
	/**
	 * 保存
	 * @param building
	 */
	public JPACommunityBuilding save(JPACommunityBuilding building);
}
