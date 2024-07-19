package com.watches.services.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.watches.entities.Brand;
import com.watches.entities.Gender;
import com.watches.entities.Watch;
import com.watches.entities.WatchPage;
import com.watches.services.dao.WatchDao;

@Repository
public class WatchImpl implements WatchDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Watch> getAll() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Watch");
		List data = query.getResultList();
		session.close();
		return data;
	}

	@Override
	public List<Watch> search(String name) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Watch where watchName like :name");
		query.setParameter("name", "%" + name + "%");
		return query.getResultList();
	}

	@Override
	public Watch get(Integer key) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Watch where watchId=?1");
		query.setParameter(1, key);
		Watch data = (Watch) query.getSingleResult();
		session.close();
		return data;
	}

	@Override
	public boolean insert(Watch obj) {
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
	public boolean update(Watch obj) {
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
			int i = session.createQuery("delete from Watch where watchId = :watchId").setParameter("watchId", key)
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

	@Override
	public List<Gender> getByCategory(int categoryId) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Watch where watchId=?1");
		List data = query.setParameter(1, categoryId).getResultList();
		session.close();
		return data;
	}

	@Override
	public List<Brand> getByBrand(int brandId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Brand> getByColor(int colorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Watch get(String slug) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM Watch WHERE WatchSlug = :slug").setParameter("slug", slug);
		Watch data = (Watch) query.getSingleResult();
		return data;
	}

	@Override
	public WatchPage getAllWithPaging(int pageSize, int pageNo) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		int records=0;
		Query query=session.createQuery("from Watch");
		records=query.getResultList().size();
		query.setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).getResultList();
		List result=query.getResultList();
		WatchPage wp = new WatchPage();
		wp.setWatches(result);
		wp.setCurrentPage(pageNo);
		wp.setPageSize(pageSize);
		int totalpage=records%pageSize==0?records/pageSize:(records/pageSize)+1;
		wp.setTotalPages(totalpage);
		session.close();
		return wp;
		
	}

	@Override
	public WatchPage getByGender(int pageSize, int pageNo, String genderName) {
		return null;
		
	}

	@Override
	public WatchPage getByBrand(int pageSize, int pageNo, String brandName) {
		// TODO Auto-generated method stub
		return null;
	}

}
