package com.watches.services.dao;

import java.util.List;

import com.watches.entities.Account;


public interface AccountDao {
	public List<Account> getAll();

	public boolean insert(Account acc);

	public boolean update(Account acc);

	public boolean delete(String key);

	public Account getAccount(String userName);
	public Account get(String key);
}
