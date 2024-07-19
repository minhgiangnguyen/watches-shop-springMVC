package com.watches.services.dao;
import java.util.List;
import com.watches.entities.Material;

public interface MaterialDao {
	public List<Material> getAll();
	   public boolean insert(Material mt);
	   public boolean  update(Material mt);
	   public boolean delete(int mtkey);
	   public Material getById(int mtkey);
	   public List<Material> search(String name);
}
