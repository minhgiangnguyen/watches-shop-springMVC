package com.watches.services.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.watches.entities.Brand;
import com.watches.services.dao.BrandDao;
@Repository
public class BrandImpl implements BrandDao{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Brand> getAll() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Brand");
		List data = query.getResultList();
		session.close();
		return data;
	}

	@Override
	public List<Brand> search(String name) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Brand where brandName like :name");
		query.setParameter("name", "%" + name + "%");
		return query.getResultList();
	}

	@Override
	public Brand get(Integer key) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Brand where brandId=?1");
		query.setParameter(1, key);
		Brand data = (Brand) query.getSingleResult();
		session.close();
		return data;
	}

	@Override
	public boolean insert(Brand obj) {
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
	public boolean update(Brand obj) {
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
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			int i = session.createQuery("delete from Brand where brandId = :brandId")
					.setParameter("brandId", key)
					.executeUpdate();
			session.getTransaction().commit();
			if (i > 0)
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
	
}
