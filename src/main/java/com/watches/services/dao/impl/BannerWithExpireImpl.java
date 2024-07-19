package com.watches.services.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.watches.entities.BannerWithExpire;
import com.watches.entities.Promotion;
import com.watches.services.dao.BannerWithExpireDAO;

@Repository
public class BannerWithExpireImpl implements BannerWithExpireDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<BannerWithExpire> getAll() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from BannerWithExpire order by expire");
		List data = query.getResultList();
		session.close();
		return data;
	}

	@Override
	public List<BannerWithExpire> search(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public BannerWithExpire get() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from BannerWithExpire where startDate <=CONVERT(DATE, GETDATE()) "
				+ "and endDate>=CONVERT(DATE, GETDATE())");
		Query queryDefault = session.createQuery("from BannerWithExpire where defaultBanner=1");
		BannerWithExpire dataDefault = (BannerWithExpire) queryDefault.getSingleResult();
		@SuppressWarnings("unchecked")
		BannerWithExpire data = (BannerWithExpire) query.getResultStream().findFirst().orElse(dataDefault);
		session.close();
		return data;
	}
	@Override
	public BannerWithExpire get(Integer key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(BannerWithExpire obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(BannerWithExpire obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer key) {
		// TODO Auto-generated method stub
		return false;
	}

	

	

}
