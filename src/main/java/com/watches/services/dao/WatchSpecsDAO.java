package com.watches.services.dao;

import java.util.List;

import com.watches.entities.WatchPage;
import com.watches.entities.WatchSpecs;

public interface WatchSpecsDAO extends GenericDao<WatchSpecs, Integer> {
	public WatchPage getAllWithPaging(int pageSize,int pageNo);
	public WatchPage getByGender(int pageSize, int pageNo,String categoryName);
	public WatchPage getByBrand(int pageSize, int pageNo,String brandName);
	public WatchPage search(int pageSize, int pageNo,String name);
	public List<WatchSpecs> getByCategory(String categoryName);
	public List<WatchSpecs> getByBrand(String brandName);
	public List<WatchSpecs> getByColor(String colorName);
	public List<WatchSpecs> filter(float fromPrice, float toPrice);
	public List<WatchSpecs> filter(String color);
	public WatchSpecs get(String slug);
	
}
