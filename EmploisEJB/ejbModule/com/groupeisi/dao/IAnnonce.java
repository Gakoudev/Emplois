package com.groupeisi.dao;

import java.util.List;

import javax.ejb.Local;

import com.groupeisi.entities.Annonce;

@Local
public interface IAnnonce extends IRepository<Annonce> {
	public List<Annonce> listdateLimite();
}
