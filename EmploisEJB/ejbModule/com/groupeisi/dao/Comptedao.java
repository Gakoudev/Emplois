package com.groupeisi.dao;

import javax.ejb.Stateless;

import com.groupeisi.entities.Compte;
@Stateless
public class Comptedao  extends RepositoryImpl<Compte> implements ICompte{
	public boolean login(String email, String password) {

		Compte user = null;
		boolean ok = false;
		try {
			user = (Compte) em.createQuery("SELECT U FROM  Compte U WHERE U.email = :email").setParameter("email", email)
					.getSingleResult();
			
			if(user != null && user.getPassword().equals(password)) {
				ok = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ok;
		
	}

	@Override
	public Compte byEmail(String email) {
		Compte user = null;
		user = (Compte) em.createQuery("SELECT U FROM  Compte U WHERE U.email = :email").setParameter("email", email)
				.getSingleResult();
		return user;
	}
	
}
