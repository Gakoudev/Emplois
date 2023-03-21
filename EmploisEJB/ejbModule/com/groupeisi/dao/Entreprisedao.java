package com.groupeisi.dao;

import javax.ejb.Stateless;

import com.groupeisi.entities.Entreprise;

@Stateless
public class Entreprisedao extends RepositoryImpl<Entreprise> implements IEntreprise{

	@Override
	public boolean login(String email, String password) {
		Entreprise user = null;
		boolean ok = false;
		try {
			user = (Entreprise) em.createQuery("SELECT U FROM  Entreprise U WHERE U.email = :email").setParameter("email", email)
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
	public Entreprise byEmail(String email) {
		Entreprise user = null;
		user = (Entreprise) em.createQuery("SELECT U FROM  Entreprise U WHERE U.email = :email").setParameter("email", email)
				.getSingleResult();
		return user;
	}

}
