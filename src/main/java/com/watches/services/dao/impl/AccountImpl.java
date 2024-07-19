package com.watches.services.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.watches.entities.Account;

import com.watches.services.dao.AccountDao;

@Repository
public class AccountImpl implements AccountDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Account> getAll() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Account");
		List data = query.getResultList();
		session.close();
		return data;
	}

	@Override
	public boolean insert(Account acc) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(acc);
		session.getTransaction().commit();
		session.close();
		return false;
	}

	@Override
	public boolean update(Account acc) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(acc);
		session.getTransaction().commit();
		session.close();
		return false;
	}

	@Override
	public boolean delete(String key) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Account account = session.find(Account.class, key);
		session.remove(account);
		session.getTransaction().commit();
		session.close();
		return false;
	}

	@Override
	public Account getAccount(String userName) {
		Account account = null;
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Account where userName=:userName");
		query.setParameter("userName", userName);
		try {
			account = (Account) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return account;
	}
	@Override
	public Account get(String key) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Account where accountId=?1");
		query.setParameter(1, key);
		Account data = (Account) query.getSingleResult();
		session.close();
		return data;
	}
}
