package com.groupeisi.dao;

import javax.ejb.Stateless;

import com.groupeisi.entities.CV;

@Stateless
public class CVdao  extends RepositoryImpl<CV> implements ICV{

	@Override
	public CV samaCv(int id) {
		CV cv = (CV) em.createQuery("SELECT U FROM  CV U WHERE U.compte.id = :id").setParameter("id", id)
				.getSingleResult();
		return cv;
	}

}
