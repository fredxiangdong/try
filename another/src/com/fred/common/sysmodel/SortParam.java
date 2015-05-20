package com.fred.common.sysmodel;

public class SortParam {
	
	  public static final String SORT_TYPE_ASCENDING = "ASC";
	  public static final String SORT_TYPE_DESCENDING = "DESC";
	  private String sortProperty;
	  private String sortType = "ASC";
	  private String alias;

	  public String getAlias()
	  {
	    return this.alias;
	  }

	  public void setAlias(String alias)
	  {
	    this.alias = alias;
	  }

	  public SortParam(String property, String type)
	  {
	    this.sortProperty = property;
	    this.sortType = type;
	  }

	  public SortParam(String property, String type, String alias)
	  {
	    this.sortProperty = property;
	    this.sortType = type;
	    this.alias = alias;
	  }

	  public String getSortProperty()
	  {
	    return this.sortProperty;
	  }

	  public void setSortProperty(String sortProperty)
	  {
	    this.sortProperty = sortProperty;
	  }

	  public String getSortType()
	  {
	    return this.sortType;
	  }

	  public void setSortType(String sortType)
	  {
	    this.sortType = sortType;
	  }
	}