package com.watches.services.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.watches.entities.Movements;

import com.watches.services.dao.MovementDao;
@Repository
public class MovementImpl implements MovementDao{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Movements> getAll() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Movements");
		List data = query.getResultList();
		session.close();
		return data;
	}

	@Override
	public boolean insert(Movements m) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(m);
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
	public boolean update(Movements m) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(m);
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
	public boolean delete(int mkey) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			int i = session.createQuery("delete from Movements where movementId = :movementId")
					.setParameter("movementId", mkey).executeUpdate();
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
	public Movements getById(int mkey) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Movements where movementId=?1");
		query.setParameter(1, mkey);
		Movements data = (Movements) query.getSingleResult();
		session.close();
		return data;
	}

	@Override
	public List<Movements> search(String name) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Movements where movementName like :name");
		query.setParameter("name", "%" + name + "%");
		return query.getResultList();
	}

}
