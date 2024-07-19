package com.watches.services.dao;

import java.util.List;

import com.watches.entities.Brand;
import com.watches.entities.Gender;
import com.watches.entities.Watch;
import com.watches.entities.WatchPage;

public interface WatchDao extends GenericDao<Watch, Integer>{
public List<Gender> getByCategory(int categoryId);
	
	public List<Brand> getByBrand(int brandId);
	public List<Brand> getByColor(int colorId);
	public Watch get(String slug);
	
	public WatchPage getAllWithPaging(int pageSize,int pageNo);
	public WatchPage getByGender(int pageSize, int pageNo,String genderName);
	public WatchPage getByBrand(int pageSize, int pageNo,String brandName);
	
}
