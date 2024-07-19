package com.watches.services.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.watches.entities.OrderDetail;
import com.watches.entities.OrderWatch;
import com.watches.services.dao.OrderDao;
@Repository
public class OrderImpl implements OrderDao{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<OrderWatch> getAll() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from OrderWatch");
		List data = query.getResultList();
		session.close();
		return data;
	}

	@Override
	public List<OrderWatch> search(String name) {		
		return null;
	}

	@Override
	public OrderWatch get(String key) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from OrderWatch where orderId=?1");
		query.setParameter(1, key);
		OrderWatch data = (OrderWatch ) query.getSingleResult();
		session.close();
		return data;
	}

	@Override
	public boolean insert(OrderWatch obj) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean update(OrderWatch obj) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(obj);
		session.getTransaction().commit();
		session.close();
		return false;
		
	}

	@Override
	public boolean delete(String key) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		OrderWatch orderW = session.find(OrderWatch.class, key);
		session.remove(orderW);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean insertOrderDetail(OrderWatch order, List<OrderDetail> details) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(order);
			for (OrderDetail orderDetail : details) {
				session.save(orderDetail);
			}
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

}
