package com.fred.trying.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fred.common.entity.EntityBean;

@Entity 
/*@Subselect("select r.party_id_to ORG_ID,r.party_id_from as PAR_ORG_ID" +
		" from com_party_relationship r where r.relationship_type_id=1 and sysdate between r.from_date and r.thru_date")
@Synchronize( {"com_party_relationship"} )*/
public class OrgorgRel extends EntityBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ORG_ID")
	private Long orgId;

	@Column(name = "PAR_ORG_ID")
	private Long parOrgId;

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public Long getParOrgId() {
		return parOrgId;
	}

	public void setParOrgId(Long parOrgId) {
		this.parOrgId = parOrgId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
