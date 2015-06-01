package com.fred.trying.entity;

import java.util.Date;

/**
 * CrmCommunityBuilding entity. 
 * @author MyEclipse Persistence Tools
 */

public class CrmCommunityBuilding implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String buildingId;
	private String communityId;
	private String projectId;
	private String buildingCode;
	private String buildingName;
	private Short buildingUnit;
	private Short buildingLevel;
	private Short levelCount;
	private String buildUnit;
	private Date createdStamp;
	private String createdByUserLogin;
	private Date lastUpdatedStamp;
	private String lastModifiedByUserLogin;
	private String remark;

	// Constructors

	/** default constructor */
	public CrmCommunityBuilding() {
	}

	/** minimal constructor */
	public CrmCommunityBuilding(String buildingId) {
		this.buildingId = buildingId;
	}

	/** full constructor */
	public CrmCommunityBuilding(String buildingId, String communityId,
			String projectId, String buildingCode, String buildingName,
			Short buildingUnit, Short buildingLevel, Short levelCount,
			String buildUnit, Date createdStamp, String createdByUserLogin,
			Date lastUpdatedStamp, String lastModifiedByUserLogin, String remark) {
		this.buildingId = buildingId;
		this.communityId = communityId;
		this.projectId = projectId;
		this.buildingCode = buildingCode;
		this.buildingName = buildingName;
		this.buildingUnit = buildingUnit;
		this.buildingLevel = buildingLevel;
		this.levelCount = levelCount;
		this.buildUnit = buildUnit;
		this.createdStamp = createdStamp;
		this.createdByUserLogin = createdByUserLogin;
		this.lastUpdatedStamp = lastUpdatedStamp;
		this.lastModifiedByUserLogin = lastModifiedByUserLogin;
		this.remark = remark;
	}

	// Property accessors

	public String getBuildingId() {
		return this.buildingId;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}

	public String getCommunityId() {
		return this.communityId;
	}

	public void setCommunityId(String communityId) {
		this.communityId = communityId;
	}

	public String getProjectId() {
		return this.projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getBuildingCode() {
		return this.buildingCode;
	}

	public void setBuildingCode(String buildingCode) {
		this.buildingCode = buildingCode;
	}

	public String getBuildingName() {
		return this.buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public Short getBuildingUnit() {
		return this.buildingUnit;
	}

	public void setBuildingUnit(Short buildingUnit) {
		this.buildingUnit = buildingUnit;
	}

	public Short getBuildingLevel() {
		return this.buildingLevel;
	}

	public void setBuildingLevel(Short buildingLevel) {
		this.buildingLevel = buildingLevel;
	}

	public Short getLevelCount() {
		return this.levelCount;
	}

	public void setLevelCount(Short levelCount) {
		this.levelCount = levelCount;
	}

	public String getBuildUnit() {
		return this.buildUnit;
	}

	public void setBuildUnit(String buildUnit) {
		this.buildUnit = buildUnit;
	}

	public Date getCreatedStamp() {
		return this.createdStamp;
	}

	public void setCreatedStamp(Date createdStamp) {
		this.createdStamp = createdStamp;
	}

	public String getCreatedByUserLogin() {
		return this.createdByUserLogin;
	}

	public void setCreatedByUserLogin(String createdByUserLogin) {
		this.createdByUserLogin = createdByUserLogin;
	}

	public Date getLastUpdatedStamp() {
		return this.lastUpdatedStamp;
	}

	public void setLastUpdatedStamp(Date lastUpdatedStamp) {
		this.lastUpdatedStamp = lastUpdatedStamp;
	}

	public String getLastModifiedByUserLogin() {
		return this.lastModifiedByUserLogin;
	}

	public void setLastModifiedByUserLogin(String lastModifiedByUserLogin) {
		this.lastModifiedByUserLogin = lastModifiedByUserLogin;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}