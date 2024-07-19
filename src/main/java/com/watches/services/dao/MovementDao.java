package com.watches.services.dao;

import java.util.List;

import com.watches.entities.Movements;

public interface MovementDao {
	public List<Movements> getAll();
	public boolean insert(Movements m);
	public boolean update(Movements m);
	public boolean delete(int mkey);
	public Movements getById(int mkey);
	public List<Movements> search(String name);
}
