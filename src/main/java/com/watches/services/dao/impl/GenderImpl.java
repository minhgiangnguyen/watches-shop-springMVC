package com.watches.services.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.watches.entities.Gender;
import com.watches.services.dao.GenderDao;
@Repository
public class GenderImpl implements GenderDao{
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public List<Gender> getAll() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Gender");
		List<Gender> data = query.getResultList();
		session.close();
		return data;
	}

	@Override
	public List<Gender> search(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gender get(Integer key) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Gender where genderId=?1");
		query.setParameter(1, key);
		Gender data = (Gender) query.getSingleResult();
		session.close();
		return data;
	}

	@Override
	public boolean insert(Gender obj) {
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
	public boolean update(Gender obj) {
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
			int i = session.createQuery("delete from Gender where genderId = :genderId")
					.setParameter("genderId", key)
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
