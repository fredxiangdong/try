package com.fred.common.rightaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.fred.common.entity.EntityBean;
import com.fred.common.sysmodel.QueryParamList;

/*@Aspect
@Component*/
public class RightAop {
	
	/**
	 * Load pointcut.
	 */
	@Pointcut("execution (public * com.fred.trying.service.impl.JPABuildingServiceImpl.doRetriveAop(..))")
	public void loadPointcut(){}
	
	
	@Around("loadPointcut()")
	public Object anyMethod(ProceedingJoinPoint pjp){
		Object retVal = null;
		Object[] args = pjp.getArgs();
		@SuppressWarnings("unchecked")
		Class<? extends EntityBean> clazz = (Class<? extends EntityBean>)args[0];
		if (EntityBean.class.isAssignableFrom(clazz)){
			String extJpql = (String) args[2];
			QueryParamList extParams = (QueryParamList) args[3];
			if (extParams == null)
				extParams = new QueryParamList();
			extJpql = RowRightUtil.getRight(RightItemCodeUtil.getRightItemCode(), clazz, extJpql, extParams);
			args[2] = extJpql;
			args[3] = extParams;
		}
		try {
			retVal = pjp.proceed(args);
		} catch (Throwable e){
			e.printStackTrace();
		}
		return retVal;
	}
}
