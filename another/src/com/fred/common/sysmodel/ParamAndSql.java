package com.fred.common.sysmodel;

import java.util.ArrayList;
import java.util.List;

public class ParamAndSql {
	  private String sqlString = "";
	  private List<Object> params = new ArrayList<Object>();

	  public String getSqlString()
	  {
	    return this.sqlString; }

	  public void setSqlString(String sqlString) {
	    this.sqlString = sqlString; }

	  public List<Object> getParams() {
	    return this.params; }

	  public void setParams(List<Object> params) {
	    this.params = params;
	  }
	}
