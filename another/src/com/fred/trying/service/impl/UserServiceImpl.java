package com.fred.trying.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fred.trying.entity.TbUser;
import com.fred.trying.service.UserService;

@Component("userService")
public class UserServiceImpl implements UserService{

	@PersistenceContext(unitName ="ebwebPU")
	private EntityManager em; 
	
	public TbUser retrive(String username, String password) {
		try{
			//�����ַ���ƴ�ӵĲ�ѯ��䣬����ע�빥��
//		    String jpql = "from TbUser  where userName = '"+username+"' and  password = '"+password +"'";
			String jpql = "from TbUser where userName =:userName and password =:password ";
			Query query = em.createQuery(jpql);
			query.setParameter("userName", username);
			query.setParameter("password", password);
			List<?> userLs= query.getResultList();
			TbUser user = null;
			if(userLs.size() != 0){
				user = (TbUser)userLs.get(0);
			}
			return user;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void save(TbUser user) {
		em.merge(user);
	}

}
