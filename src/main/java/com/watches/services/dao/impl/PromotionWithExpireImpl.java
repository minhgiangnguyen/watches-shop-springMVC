package com.watches.services.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.watches.entities.PromotionWithExpire;
import com.watches.services.dao.PromotionWithExpireDAO;

@Repository
public class PromotionWithExpireImpl implements PromotionWithExpireDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<PromotionWithExpire> getAll() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from PromotionWithExpire order by expire");
		List data = query.getResultList();
		session.close();
		return data;
	}

	@Override
	public List<PromotionWithExpire> search(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PromotionWithExpire get(Integer key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(PromotionWithExpire obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(PromotionWithExpire obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer key) {
		// TODO Auto-generated method stub
		return false;
	}

}
