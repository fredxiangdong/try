package com.fred.system;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthInterceptor extends AbstractInterceptor {  
	
	private static final long serialVersionUID = 2734104159013273778L;
	private String sessionKey="loginName";  
	private String parmKey="withoutAuthentication";  
	private boolean excluded;  
  
  @Override  
  public String intercept(ActionInvocation invocation) throws Exception {  
      
    ActionContext ac = invocation.getInvocationContext();  
    Map<?, ?> session =ac.getSession();  
    String parm=(String) ac.getParameters().get(parmKey);  
      System.out.println("test interceptor");
    if(parm!=null){  
      excluded = parm.toUpperCase().equals("TRUE");  
    }  
      
    String user=(String)session.get(sessionKey);  
    if(excluded || user!=null){  
      return invocation.invoke();  
    }  
    ac.put("tip", "您还没有登录!");  
    //直接返回 login 的逻辑视图    
        return Action.LOGIN;   
  }  
} 
