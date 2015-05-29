package com.fred.common.entity.listener;

import java.sql.Timestamp;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fred.common.entity.AuditEntityBean;
import com.fred.trying.entity.TbUser;
import com.opensymphony.xwork2.ActionContext;

public class EntityListener {

	private String getUser()
	  {
		TbUser user = (TbUser)ActionContext.getContext().getSession().get("user");
		return user.getUserName();
	  }

	  @PreUpdate
	  public void preUpdate(Object entity)
	  {
	    if ((entity != null) && (entity instanceof AuditEntityBean))
	    {
	      AuditEntityBean abean = (AuditEntityBean)entity;
	      abean.setLastUpdatedStamp(new Timestamp(System.currentTimeMillis()));
	      abean.setLastModifiedByUserLogin(getUser());
	    }
	  }

	  @PrePersist
	  public void prePersist(Object entity)
	  {
	    if ((entity != null) && (entity instanceof AuditEntityBean))
	    {
	      AuditEntityBean abean = (AuditEntityBean)entity;
	      abean.setCreatedStamp(new Timestamp(System.currentTimeMillis()));
	      abean.setCreatedByUserLogin(getUser());
	    }
	  }
}
