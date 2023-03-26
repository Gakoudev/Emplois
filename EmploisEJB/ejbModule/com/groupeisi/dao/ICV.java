package com.groupeisi.dao;

import javax.ejb.Local;

import com.groupeisi.entities.CV;

@Local
public interface ICV extends IRepository<CV>{
	public CV samaCv(int id);
}
