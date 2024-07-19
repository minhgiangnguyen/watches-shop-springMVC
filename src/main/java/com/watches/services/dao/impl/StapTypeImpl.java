package com.watches.services.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.watches.entities.StrapType;
import com.watches.services.dao.StrapTypeDao;

@Repository
public class StapTypeImpl implements StrapTypeDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<StrapType> getAll() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from StrapType");
		List data = query.getResultList();
		session.close();
		return data;
	}

	@Override
	public boolean insert(StrapType st) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(st);
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
	public boolean update(StrapType st) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(st);
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
	public boolean delete(int stkey) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			int i = session.createQuery("delete from StrapType where strapTypeId = :strapTypeId")
					.setParameter("strapTypeId", stkey).executeUpdate();
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
	public StrapType getById(int stkey) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from StrapType where strapTypeId=?1");
		query.setParameter(1, stkey);
		StrapType data = (StrapType) query.getSingleResult();
		session.close();
		return data;
	}

	@Override
	public List<StrapType> search(String name) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from StrapType where strapName like :name");
		query.setParameter("name", "%" + name + "%");
		return query.getResultList();
	}

	

}
