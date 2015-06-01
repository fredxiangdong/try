package com.fred.common.rightaop;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.fred.trying.entity.TbUser;
import com.opensymphony.xwork2.ActionContext;

@Aspect
@Component
public class RightAop {
	
	@PersistenceContext(unitName="ebwebPU")
	private EntityManager em;

	@Pointcut("execution (public * com.fred.common.rightaop.AopRetriveServiceImpl.doRetrive(..))")
	public void loadPointcut(){}
	
	@Around("loadPointcut()")
	public Object anyMethod(ProceedingJoinPoint pjp){
		TbUser user = (TbUser)ActionContext.getContext().getSession().get("user");
		Object retVal = null;
		Object[] args = pjp.getArgs();
		args[0] = args[0] + " and unitCode =:unitCode ";
		Query query = em.createQuery(args[0].toString());
		query.setParameter("unitCode", user.getUnitCode());
		args[1] = query;
		try {
			retVal = pjp.proceed(args);
		} catch (Throwable e){
			e.printStackTrace();
		}
		return retVal;
	}
}
