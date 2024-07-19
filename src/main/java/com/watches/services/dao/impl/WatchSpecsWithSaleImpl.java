package com.watches.services.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.watches.entities.Watch;
import com.watches.entities.WatchPage;
import com.watches.entities.WatchSpecsWithSale;
import com.watches.entities.WatchTopBuy;
import com.watches.services.dao.WatchSpecsWithSaleDAO;

@Repository
public class WatchSpecsWithSaleImpl implements WatchSpecsWithSaleDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public List<WatchSpecsWithSale> getAll() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from WatchSpecsWithSale");
		List data = query.getResultList();
		session.close();
		return data;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WatchSpecsWithSale> search(String name) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from WatchSpecsWithSale where watchName like :name");
		query.setParameter("name", "%" + name + "%");
		return query.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<WatchSpecsWithSale> search(String name, int limit) {
		Session session = sessionFactory.openSession();
		String sql="SELECT TOP (:limit) * FROM vw_WatchSpecsWithSale where watchName like :name";
		Query query = session.createNativeQuery(sql,WatchSpecsWithSale.class)
				.setParameter("name", "%" + name + "%")
				.setParameter("limit", limit);
		return query.getResultList();
	}

	@Override
	public WatchSpecsWithSale get(Integer key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(WatchSpecsWithSale obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(WatchSpecsWithSale obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public WatchSpecsWithSale get(String slug) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM WatchSpecsWithSale WHERE WatchSlug = :slug").setParameter("slug", slug);
		WatchSpecsWithSale data = (WatchSpecsWithSale) query.getSingleResult();
		return data;
	}

	@Override
	public WatchPage getAllWithPaging(int pageSize, int pageNo) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query= session.createQuery("FROM WatchSpecsWithSale");
		int totalPro=query.getResultList().size();
		query.setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).getResultList();
		List data = query.getResultList();
		WatchPage wp = new WatchPage();
		wp.setCurrentPage(pageNo);
		wp.setPageSize(pageSize);
		int totalPage=totalPro%pageSize==0?totalPro/pageSize:(totalPro/pageSize)+1;
		wp.setTotalPages(totalPage);
		wp.setWatches(data);
		session.close();	
		return wp;
	}

	@Override
	public WatchPage getByGender(int pageSize, int pageNo, String gender) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query= session.createQuery("FROM WatchSpecsWithSale WHERE genderName = :name")
					.setParameter("name", gender);
		int totalPro=query.getResultList().size();
		query.setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).getResultList();
		List data = query.getResultList();
		WatchPage wp = new WatchPage();
		wp.setCurrentPage(pageNo);
		wp.setPageSize(pageSize);
		int totalPage=totalPro%pageSize==0?totalPro/pageSize:(totalPro/pageSize)+1;
		wp.setTotalPages(totalPage);
		wp.setWatches(data);
		session.close();	
		return wp;
	}

	@Override
	public WatchPage getByBrand(int pageSize, int pageNo, String brandName) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query= session.createQuery("FROM WatchSpecsWithSale WHERE brandName = :name")
					.setParameter("name", brandName);
		int totalPro=query.getResultList().size();
		query.setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).getResultList();
		List data = query.getResultList();
		WatchPage wp = new WatchPage();
		wp.setCurrentPage(pageNo);
		wp.setPageSize(pageSize);
		int totalPage=totalPro%pageSize==0?totalPro/pageSize:(totalPro/pageSize)+1;
		wp.setTotalPages(totalPage);
		wp.setWatches(data);
		session.close();	
		return wp;
	}

	

	@Override
	public List<WatchSpecsWithSale> getByGender(String genderName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WatchSpecsWithSale> getByBrand(String brandName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WatchSpecsWithSale> getByColor(String colorName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WatchSpecsWithSale> filter(float fromPrice, float toPrice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WatchSpecsWithSale> filter(String color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WatchSpecsWithSale> getAllSale() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from WatchSpecsWithSale where haveSale=1");
		List data = query.getResultList();
		session.close();
		return data;
	}

	@Override
	public List<WatchSpecsWithSale> getLastestWatches(int limit) {
		Session session = sessionFactory.openSession();
		String sql="SELECT TOP (?) * FROM vw_WatchSpecsWithSale order by UpdateDate DESC";
		Query query = session.createNativeQuery(sql,WatchSpecsWithSale.class)
				.setParameter(1, limit);
		@SuppressWarnings("unchecked")
		List<WatchSpecsWithSale> data = query.getResultList();
		session.close();
		return data;
	}

	

}
