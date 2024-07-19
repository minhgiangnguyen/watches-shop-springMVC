package com.watches.services.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.watches.entities.PromotionWatch;
import com.watches.services.dao.PromotionWatchDAO;
@Repository
public class PromotionWatchImpl implements PromotionWatchDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<PromotionWatch> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PromotionWatch> search(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PromotionWatch get(Integer key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(PromotionWatch obj) {
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
	public boolean update(PromotionWatch obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int watchId, int promoId) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			int i = session.createQuery("delete from PromotionWatch where watchId = :watchId and promoId = :promoId")
					.setParameter("watchId", watchId)
					.setParameter("promoId", promoId)
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
