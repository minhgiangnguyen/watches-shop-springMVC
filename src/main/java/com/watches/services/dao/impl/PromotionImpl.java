package com.watches.services.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.watches.entities.Promotion;
import com.watches.entities.Watch;
import com.watches.services.dao.PromotionDAO;
@Repository
public class PromotionImpl implements PromotionDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Promotion> getAll() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Promotion");
		List data = query.getResultList();
		session.close();
		return data;
	}

	@Override
	public List<Promotion> search(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Promotion get(Integer key) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Promotion where promotionId=?1");
		query.setParameter(1, key);
		Promotion data = (Promotion) query.getSingleResult();
		session.close();
		return data;
	}

	@Override
	public boolean insert(Promotion obj) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(obj);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean update(Promotion obj) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(obj);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean delete(Integer key) {
		// TODO Auto-generated method stub
		return false;
	}

}
