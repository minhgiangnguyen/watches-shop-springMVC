package com.watches.services.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.watches.entities.Sizes;

import com.watches.services.dao.SizeDao;
@Repository
public class SizeImpl implements SizeDao{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Sizes> getAll() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Sizes");
		List data = query.getResultList();
		session.close();
		return data;
	}

	@Override
	public boolean insert(Sizes s) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(s);
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
	public boolean update(Sizes s) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(s);
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
	public boolean delete(int skey) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			int i = session.createQuery("delete from Sizes where sizeId = :sizeId")
					.setParameter("sizeId", skey).executeUpdate();
			session.getTransaction().commit();
			if(i > 0)
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
	public Sizes getById(int skey) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Sizes where sizeId=?1");
		query.setParameter(1, skey);
		Sizes data = (Sizes) query.getSingleResult();
		session.close();
		return data;
	}

	@Override
	public List<Sizes> search(int sizeValue) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Sizes where sizeValue = :sizeValue");
		query.setParameter("sizeValue",  sizeValue );
		return query.getResultList();
	}

}
