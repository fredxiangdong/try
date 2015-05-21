package com.fred.common.entity.listener;

import java.sql.Timestamp;
import java.util.Map;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fred.common.entity.AuditEntityBean;
import com.fred.trying.entity.User;
import com.opensymphony.xwork2.ActionContext;

public class EntityListener {

	private String getUser()
	  {
		Map session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		if(user == null) return "no user";//加拦截器之后其实不必要
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
