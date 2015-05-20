package com.fred.common.sysmodel;

import java.util.ArrayList;
import java.util.List;

public class SortParamList {
	private List<SortParam> params = new ArrayList<SortParam>();

	  public void addParam(SortParam param)
	  {
	    if ((param == null) || (param.getSortProperty() == null) || ("".equals(param.getSortProperty()))) return;
	    this.params.add(param);
	  }

	  public void addParam(String property, String type)
	  {
	    SortParam sortParam = new SortParam(property, type);
	    this.params.add(sortParam);
	  }

	  public void addParam(String property, String type, String alias)
	  {
	    SortParam sortParam = new SortParam(property, type, alias);
	    this.params.add(sortParam);
	  }

	  public List<SortParam> getParams()
	  {
	    return this.params;
	  }

	  public void setParams(List<SortParam> params)
	  {
	    this.params = params;
	  }

	  public int size()
	  {
	    return ((this.params == null) ? 0 : this.params.size());
	  }

	  public boolean hasParam(String paramName)
	  {
	    if (this.params == null)
	      return false;
	    return this.params.contains(paramName);
	  }
	}