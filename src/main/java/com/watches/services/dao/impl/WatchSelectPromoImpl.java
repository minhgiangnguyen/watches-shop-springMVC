package com.watches.services.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.watches.entities.WatchSelectPromo;
import com.watches.entities.WatchWithPromotion;
import com.watches.services.dao.WatchSelectPromoDAO;

@Repository
public class WatchSelectPromoImpl implements WatchSelectPromoDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<WatchSelectPromo> getAll() {
		return null;
		
	}

	@Override
	public List<WatchSelectPromo> search(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WatchSelectPromo get(Integer key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(WatchSelectPromo obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(WatchSelectPromo obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<WatchSelectPromo> getWatchesSelect(int promoId) {
		Session session = sessionFactory.openSession();
		Query query = session.createNamedQuery("watchSelectList",WatchSelectPromo.class)
				.setParameter("promoId",promoId);
		List<WatchSelectPromo> data = query.getResultList();
		return data;
	}

}
