package com.watches.services.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.watches.entities.Color;
import com.watches.services.dao.ColorDao;
@Repository
public class ColorImpl implements ColorDao{
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public List<Color> getAll() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Color");
		List data = query.getResultList();
		session.close();
		return data;
	}

	@Override
	public List<Color> search(String name) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Color where colorValue like :name");
		query.setParameter("name", "%" + name + "%");
		return query.getResultList();
	}

	@Override
	public Color get(Integer key) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Color where colorId=?1");
		query.setParameter(1, key);
		Color data = (Color) query.getSingleResult();
		session.close();
		return data;
	}

	@Override
	public boolean insert(Color obj) {
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
	public boolean update(Color obj) {
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
			int i = session.createQuery("delete from Color where colorId = :colorId")
					.setParameter("colorId", key)
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
