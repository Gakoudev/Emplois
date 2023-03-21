package com.groupeisi.dao;

import javax.ejb.Local;

import com.groupeisi.entities.Entreprise;

@Local
public interface IEntreprise extends IRepository<Entreprise>{
	public boolean login(String email, String password);
	public Entreprise byEmail(String email);
}
