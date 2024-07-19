package com.watches.services.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.watches.entities.WatchSpecsWithSale;
import com.watches.entities.WatchTopBuy;
import com.watches.services.dao.WatchTopBuyDAO;
@Repository
public class WatchTopBuyImpl implements WatchTopBuyDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public List<WatchTopBuy> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WatchTopBuy> search(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WatchTopBuy get(Integer key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(WatchTopBuy obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(WatchTopBuy obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<WatchTopBuy> getLimit(int limit) {
		Session session = sessionFactory.openSession();
		String sql="SELECT TOP (?) * FROM vw_WatchesTopBy ORDER BY CountWatch desc";
		Query query = session.createNativeQuery(sql,WatchTopBuy.class)
				.setParameter(1, limit);
		@SuppressWarnings("unchecked")
		List<WatchTopBuy> data = query.getResultList();
		session.close();
		return data;
	}

}
