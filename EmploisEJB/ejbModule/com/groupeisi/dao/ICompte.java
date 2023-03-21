package com.groupeisi.dao;

import javax.ejb.Local;

import com.groupeisi.entities.Compte;

@Local
public interface ICompte extends IRepository<Compte>{
	public boolean login(String email, String password);
	public Compte byEmail(String email);
}
