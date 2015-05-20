package com.fred.trying.service;

import java.util.List;

import com.fred.trying.entity.CrmCommunityBuilding;

public interface BuildingService {
	/**
	 * 查询指定信息
	 * @param Id
	 * @return
	 */
	public List<CrmCommunityBuilding> retriveAll(String Id);
	/**
	 * 删除
	 * @param Id
	 */
	public void remove(String Id);
}
