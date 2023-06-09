package com.groupeisi.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RepositoryImpl<T>  implements IRepository<T> {

	@PersistenceContext(unitName="EMPLOIS_UP")
	protected EntityManager em;
	
	public  RepositoryImpl() {
		
	}
	@Override
	public int add(T t) {
		int result=1;
		em.persist(t);
		
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int delete(int id,T t) {
		int result=1;
		
		String table=t.getClass().getSimpleName();
        t=(T) em.createQuery("SELECT t FROM " + table + " t WHERE t.id=:id").setParameter("id", id).getSingleResult();
       
        em.remove(t);
		return result;
	}

	@Override
	public int update(T t) {
		int result=1;
		em.merge(t);
		return result;
	}
	
	
   @Override
	public List<T> list(T t) {
		String table=t.getClass().getSimpleName();
       return (List<T>) em.createQuery("SELECT t FROM " + table + " t").getResultList();
       
		
	}

    @SuppressWarnings("unchecked")
	@Override
	public T get (int id,T t) {
		String table=t.getClass().getSimpleName();
        t=(T) em.createQuery("SELECT t FROM " + table + " t WHERE t.id=:id").setParameter("id", id).getSingleResult();
        return t;
       
	}

	
}
