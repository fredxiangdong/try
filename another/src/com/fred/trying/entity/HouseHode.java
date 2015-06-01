package com.fred.trying.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.struts2.json.annotations.JSON;

@Entity
@Table(name = "HOUSE_HODE")
public class HouseHode {
	
	@Id
	@Column(name ="HOUSER_ID")
	private String houserId;
	
	@Column(name = "BUILDING_ID")
	private String buildingId;
	
	@Column(name = "HOUSER_NAME")
	private String houserName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BUILDING_ID", insertable = false, updatable = false)
	private JPACommunityBuilding building;
	
	public String getHouserId() {
		return houserId;
	}
	public void setHouserId(String houserId) {
		this.houserId = houserId;
	}
	public String getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}
	public String getHouserName() {
		return houserName;
	}
	public void setHouserName(String houserName) {
		this.houserName = houserName;
	}
	
	@JSON(serialize = false)
	public JPACommunityBuilding getBuilding() {
		return building;
	}
	
	public void setBuilding(JPACommunityBuilding building) {
		this.building = building;
	}
	
}
