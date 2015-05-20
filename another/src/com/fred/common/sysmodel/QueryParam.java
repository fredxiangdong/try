package com.fred.common.sysmodel;

public class QueryParam {
	
	  public static final String RELATION_EQUAL = "=";
	  public static final String RELATION_GT = ">";
	  public static final String RELATION_LT = "<";
	  public static final String RELATION_GE = ">=";
	  public static final String RELATION_LE = "<=";
	  public static final String RELATION_NOTEQUAL = "<>";
	  public static final String RELATION_LIKE = "LIKE";
	  public static final String RELATION_ISNULL = "IS NULL";
	  public static final String RELATION_NOTNULL = "IS NOT NULL";
	  private String name;
	  private Object value;
	  private String relation = "=";

	  public boolean needValue()
	  {
	    return ((!(this.relation.equals("IS NULL"))) && (!(this.relation.equals("IS NOT NULL"))));
	  }

	  public String getRelation()
	  {
	    return this.relation;
	  }

	  public void setRelation(String relation)
	  {
	    this.relation = relation;
	  }

	  public String getName()
	  {
	    return this.name;
	  }

	  public void setName(String name)
	  {
	    this.name = name;
	  }

	  public Object getValue()
	  {
	    return this.value;
	  }

	  public void setValue(Object value)
	  {
	    this.value = value;
	  }

	  public boolean equals(Object obj)
	  {
	    if ((obj == null) || (!(obj instanceof QueryParam)))
	      return false;
	    QueryParam p = (QueryParam)obj;
	    if (this.name != null)
	      return this.name.equals(p.name);

	    return (p.name == null);
	  }
	}