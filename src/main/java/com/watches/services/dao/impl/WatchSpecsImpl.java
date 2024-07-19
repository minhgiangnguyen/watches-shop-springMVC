package com.watches.services.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.watches.entities.Brand;
import com.watches.entities.Gender;
import com.watches.entities.Color;
import com.watches.entities.Watch;
import com.watches.entities.WatchPage;
import com.watches.entities.WatchSpecs;
import com.watches.services.dao.WatchSpecsDAO;
@Repository
public class WatchSpecsImpl implements WatchSpecsDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public List<WatchSpecs> getAll() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from WatchSpecs");
		List data = query.getResultList();
		session.close();
		return data;
	}

	@Override
	public List<WatchSpecs> search(String name) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from WatchSpecs where watchName like :name");
		query.setParameter("name", "%" + name + "%");
		return query.getResultList();
	}
	@Override
	public WatchPage search(int pageSize, int pageNo, String name) {
		return null;
		
	}
	@Override
	public WatchSpecs get(Integer key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(WatchSpecs obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(WatchSpecs obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public WatchPage getAllWithPaging(int pageSize, int pageNo) {
		return null;
	
	}

	@Override
	public WatchPage getByGender(int pageSize, int pageNo,String gender) {
		return null;
		
	}

	@Override
	public List<WatchSpecs> getByBrand(String brandName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WatchSpecs> getByColor(String colorName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WatchSpecs get(String slug) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query= session.createQuery("FROM WatchSpecs WHERE WatchSlug = :slug")
					.setParameter("slug", slug);
		WatchSpecs data = (WatchSpecs) query.getSingleResult();		
		return data;
	}

	@Override
	public List<WatchSpecs> getByCategory(String categoryName) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query= session.createQuery("FROM WatchSpecs WHERE CategoryName = :name")
					.setParameter("name", categoryName);
		List data = query.getResultList();
		return data;
	}

	@Override
	public WatchPage getByBrand(int pageSize, int pageNo, String brandName) {
		return null;
		
	}

	@Override
	public List<WatchSpecs> filter(float fromPrice, float toPrice) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=null;
		if(fromPrice==0 && toPrice>0) {
			query=session.createQuery("from WatchSpecs where price<=:toPrice").setParameter("toPrice",toPrice);
		}else if(fromPrice>0 && toPrice==0)
		{
			query=session.createQuery("from WatchSpecs where price>=:fromPrice").setParameter("fromPrice",fromPrice);
		}else {
			query=session.createQuery("from WatchSpecs where price>=:fromPrice and price<=:toPrice");
			query.setParameter("toPrice",toPrice);
			query.setParameter("fromPrice",fromPrice);
		}
		List result=query.getResultList();
		session.close();
		return result;
	}

	@Override
	public List<WatchSpecs> filter(String color) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from WatchSpecs where colorName like :name");
		query.setParameter("name", "%" + color + "%");
		return query.getResultList();
	}

	

	

	

	

	

	

}
