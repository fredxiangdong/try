package com.fred.common.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;


@MappedSuperclass
@FilterDef(name = "rightFilter", parameters = @ParamDef(name = "RIGHT_ID", type = "string"))
@Filters({
		@Filter(name = "rightFilter",condition = " UNIT_CODE in(:RIGHT_ID)" )
})
public class AuditEntityBean extends EntityBean{
	
	private static final long serialVersionUID = 1L;

	@Column(name = "UNIT_CODE")
	private String unitCode;
	
	@Column(name = "DATE_LINE")
	private String dateLine;
	
	public String getUnitCode() {
		return unitCode;
	}
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}
	public String getDateLine() {
		return dateLine;
	}
	public void setDateLine(String dateLine) {
		this.dateLine = dateLine;
	}

}
