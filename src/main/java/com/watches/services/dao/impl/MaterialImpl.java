package com.watches.services.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.watches.entities.Material;

import com.watches.services.dao.MaterialDao;

@Repository
public class MaterialImpl implements MaterialDao{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Material> getAll() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Material");
		List data = query.getResultList();
		session.close();
		return data;
	}

	@Override
	public boolean insert(Material mt) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(mt);
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
	public boolean update(Material mt) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(mt);
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
	public boolean delete(int mtkey) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			int i = session.createQuery("delete from Material where materialId = :materialId")
					.setParameter("materialId", mtkey).executeUpdate();
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
	public Material getById(int mtkey) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Material where materialId=?1");
		query.setParameter(1, mtkey);
		Material data = (Material) query.getSingleResult();
		session.close();
		return data;
	}

	@Override
	public List<Material> search(String name) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Material where materialName like :name");
		query.setParameter("name", "%" + name + "%");
		return query.getResultList();
	}
	
	
}
