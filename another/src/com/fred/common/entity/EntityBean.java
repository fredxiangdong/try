package com.fred.common.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import com.fred.common.entity.listener.EntityListener;


@MappedSuperclass
@EntityListeners(EntityListener.class)
public class EntityBean{
	
	@Column(name="CREATED_STAMP",updatable=false)
	protected Timestamp createdStamp;
	
	@Column(name="CREATED_BY_USER_LOGIN",updatable=false)
    protected String createdByUserLogin;
	
    @Column(name="LAST_UPDATED_STAMP")
    protected Timestamp lastUpdatedStamp;

    @Column(name="LAST_MODIFIED_BY_USER_LOGIN")
    protected String lastModifiedByUserLogin;

	public Timestamp getCreatedStamp() {
		return createdStamp;
	}

	public void setCreatedStamp(Timestamp createdStamp) {
		this.createdStamp = createdStamp;
	}

	public String getCreatedByUserLogin() {
		return createdByUserLogin;
	}

	public void setCreatedByUserLogin(String createdByUserLogin) {
		this.createdByUserLogin = createdByUserLogin;
	}

	public Timestamp getLastUpdatedStamp() {
		return lastUpdatedStamp;
	}

	public void setLastUpdatedStamp(Timestamp lastUpdatedStamp) {
		this.lastUpdatedStamp = lastUpdatedStamp;
	}

	public String getLastModifiedByUserLogin() {
		return lastModifiedByUserLogin;
	}

	public void setLastModifiedByUserLogin(String lastModifiedByUserLogin) {
		this.lastModifiedByUserLogin = lastModifiedByUserLogin;
	}	

}    
