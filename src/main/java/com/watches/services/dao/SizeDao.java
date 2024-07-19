package com.watches.services.dao;

import java.util.List;

import com.watches.entities.Sizes;

public interface SizeDao {
	public List<Sizes> getAll();
	   public boolean insert(Sizes s);
	   public boolean update(Sizes s);
	   public boolean delete(int skey);
	   public Sizes getById(int skey);
	   public List<Sizes> search(int sizeValue);
}
