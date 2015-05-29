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
	 * 保存
	 * @param building
	 */
	public JPACommunityBuilding save(JPACommunityBuilding building);
	
	/**
	 * 删除
	 * @param buildingId
	 */
	public void delById(String buildingId);
	
	/**
	 * 获取指定ID的building数据
	 * @param buildingId
	 */
	public JPACommunityBuilding retriveById(String buildingId);
	
	public List<JPACommunityBuilding> doRetriveAop(String jpql);
	
}
