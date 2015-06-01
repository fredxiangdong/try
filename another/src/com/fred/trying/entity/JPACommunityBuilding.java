package com.fred.trying.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.struts2.json.annotations.JSON;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;

import com.fred.common.entity.AuditEntityBean;

@Entity
@Table(name = "CRM_COMMUNITY_BUILDING")
@FilterDef(name = "rightFilter", parameters = @ParamDef(name = "RIGHT_ID", type = "string"))
@Filters({
		@Filter(name = "rightFilter",condition = " UNIT_CODE in(:RIGHT_ID)" )
})

public class JPACommunityBuilding extends AuditEntityBean{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "BUILDING_ID")
	private String buildingId;
	
	@Column(name = "COMMUNITY_ID")
	private String communityId;
	
	@Column(name = "BUILDING_CODE")
	private String buildingCode;
	
	@Column(name = "BUILDING_NAME")
	private String buildingName;
	
	@Column(name = "BUILDING_UNIT")
	private Integer buildingUnit;
	
	@Column(name = "BUILDING_LEVEL")
	private Integer buildingLevel;
	
	@Column(name = "LEVEL_COUNT")
	private Integer levelCount;
	
	@Column(name = "BUILD_UNIT")
	private String buildUnit;

	@Column(name = "REMARK")
	private String remark;
	
	@Column(name = "PROJECT_ID")
	private String projectId;
	
	@Transient
	private String communityName;//小区名称
	
	@Transient
	private String genCustomerFlag;//是否生成了具体户信息
	
	@Transient
	private String newName; // 新楼宇名
	
/*	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORG_ID", insertable = false, updatable = false)
	private OrgorgRel orgorgRel;*/

//此种一对多应用于两表列名不一致的情况，其中referencedColumnName为本类被参考的列名
/*	@OneToMany
	@JoinColumn(name = "PAR_ORG_ID", insertable = false, updatable = false, referencedColumnName = "ORG_ID")
	private List<OrgorgRel> childRel;*/
	
	@OneToMany(mappedBy = "building")
	private List<HouseHode> houseHodeLs;
	
	public String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(String buildingId){
		this.buildingId = buildingId;
	}

	public String getCommunityId() {
		return communityId;
	}

	public void setCommunityId(String communityId){
		this.communityId = communityId;
	}

	public String getBuildingCode() {
		return buildingCode;
	}

	public void setBuildingCode(String buildingCode){
		this.buildingCode = buildingCode;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName){
		this.buildingName = buildingName;
	}

	public Integer getBuildingUnit() {
		return buildingUnit;
	}

	public void setBuildingUnit(Integer buildingUnit){
		this.buildingUnit = buildingUnit;
	}

	public Integer getBuildingLevel() {
		return buildingLevel;
	}

	public void setBuildingLevel(Integer buildingLevel){
		this.buildingLevel = buildingLevel;
	}

	public Integer getLevelCount() {
		return levelCount;
	}

	public void setLevelCount(Integer levelCount){
		this.levelCount = levelCount;
	}

	public String getBuildUnit() {
		return buildUnit;
	}

	public void setBuildUnit(String buildUnit){
		this.buildUnit = buildUnit;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark){
		this.remark = remark;
	}
		
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}


	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public String getGenCustomerFlag() {
		return genCustomerFlag;
	}

	public void setGenCustomerFlag(String genCustomerFlag) {
		this.genCustomerFlag = genCustomerFlag;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	@JSON(serialize = false)
	public List<HouseHode> getHouseHodeLs() {
		return houseHodeLs;
	}

	public void setHouseHodeLs(List<HouseHode> houseHodeLs) {
		this.houseHodeLs = houseHodeLs;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}