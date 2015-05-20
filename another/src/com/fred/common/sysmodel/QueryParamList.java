package com.fred.common.sysmodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QueryParamList {
	 private List<QueryParam> params = new ArrayList<QueryParam>();

	  public void addParam(String name, Object value)
	  {
	    QueryParam param = new QueryParam();
	    param.setName(name);
	    param.setValue(value);
	    this.params.add(param);
	  }

	  public void addParam(String name, Object value, String relation)
	  {
	    QueryParam param = new QueryParam();
	    param.setName(name);
	    param.setValue(value);
	    param.setRelation(relation);
	    this.params.add(param);
	  }

	  public void addParam(QueryParam param)
	  {
	    if ((param == null) || (param.getName() == null) || (param.getValue() == null)) return;
	    this.params.add(param);
	  }

	  public void addParamList(QueryParamList aparams)
	  {
	    if ((aparams == null) || (aparams.getParams().size() <= 0))
	      return;
	    List<QueryParam> list = aparams.getParams();
	    for (int i = 0; i < list.size(); ++i)
	    {
	      QueryParam param = (QueryParam)list.get(i);
	      this.params.add(param);
	    }
	  }

	  public List<QueryParam> getParams()
	  {
	    return this.params;
	  }

	  public void setParams(List<QueryParam> params)
	  {
	    this.params = params;
	  }

	  public int size()
	  {
	    return this.params.size();
	  }

	  public QueryParam get(int index)
	  {
	    return ((QueryParam)this.params.get(index));
	  }

	  public QueryParam get(String name)
	  {
	    if (name == null) return null;
	    for (Iterator<QueryParam> localIterator = this.params.iterator(); localIterator.hasNext(); ) {
	    	QueryParam param = localIterator.next();
	
//反编译初始代码
//		      if (!(name.equals(param.getName()))) break label42;
//		      label42: return param;
		    
		    //修改后
		    if (name.equals(param.getName()))
		    	return param;
		    }
	    return null;
	  }

	  public boolean remove(String name)
	  {
	    if (name == null) return false;
		    for (Iterator<QueryParam> localIterator = this.params.iterator(); localIterator.hasNext(); ){ 
		    	QueryParam param = (QueryParam)localIterator.next();
	
//反编译初始代码
//		      if (!(name.equals(param.getName()))) break label53;
//		      this.params.remove(param); label53: return true;
		    
		    //修改后
		    if ((name.equals(param.getName()))) {
		    	this.params.remove(param);
		    	return true;
		    }
		    }
	    return false;
	  }

	  public ParamAndSql getParamAndSql()
	  {
	    ParamAndSql paramAndSql = new ParamAndSql();
	    Iterator<QueryParam> it = this.params.iterator();
	    StringBuilder sb = new StringBuilder("");
	    while (it.hasNext())
	    {
	      QueryParam item = (QueryParam)it.next();
	      sb.append(" and ").append(item.getName()).append(" ").append(item.getRelation()).append
	        (" ");
	      if (item.needValue()) { sb.append(" ? "); paramAndSql.getParams().add(item.getValue());
	      }
	    }
	    paramAndSql.setSqlString(sb.toString());
	    return paramAndSql;
	  }
	}