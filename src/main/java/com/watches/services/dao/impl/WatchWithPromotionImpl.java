package com.watches.services.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.watches.entities.WatchWithPromotion;
import com.watches.services.dao.WatchWithPromotionDAO;
@Repository
public class WatchWithPromotionImpl implements WatchWithPromotionDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<WatchWithPromotionDAO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WatchWithPromotionDAO> search(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WatchWithPromotionDAO get(Integer key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(WatchWithPromotionDAO obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(WatchWithPromotionDAO obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<WatchWithPromotion> getWatchsPromotionByPromoId(int promoId) {
		Session session = sessionFactory.openSession();
		Query query = session.createNamedQuery("watchList",WatchWithPromotion.class)
				.setParameter("promoId",promoId);
		List<WatchWithPromotion> data = query.getResultList();
		return data;
	}

}
