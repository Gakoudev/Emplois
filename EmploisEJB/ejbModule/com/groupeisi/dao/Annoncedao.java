package com.groupeisi.dao;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Stateless;

import com.groupeisi.entities.Annonce;

@Stateless
public class Annoncedao  extends RepositoryImpl<Annonce> implements IAnnonce {

	@Override
	public List<Annonce> listdateLimite() {
		return em.createQuery("SELECT t FROM Annonce t WHERE t.dateLimite > :dateLimite").setParameter("dateLimite", LocalDate.now()).getResultList();
		
	}

}
