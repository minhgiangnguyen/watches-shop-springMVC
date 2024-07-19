package com.watches.services.dao;

import java.util.List;

import com.watches.entities.WatchPage;
import com.watches.entities.WatchSpecsWithSale;
import com.watches.entities.WatchTopBuy;

public interface WatchSpecsWithSaleDAO extends GenericDao<WatchSpecsWithSale, Integer> {
	public WatchPage getAllWithPaging(int pageSize,int pageNo);
	public WatchPage getByGender(int pageSize, int pageNo,String categoryName);
	public WatchPage getByBrand(int pageSize, int pageNo,String brandName);
	public List<WatchSpecsWithSale> getByGender(String gender);
	public List<WatchSpecsWithSale> getByBrand(String brandName);
	public List<WatchSpecsWithSale> getByColor(String colorName);
	public List<WatchSpecsWithSale> filter(float fromPrice, float toPrice);
	public List<WatchSpecsWithSale> filter(String color);
	public WatchSpecsWithSale get(String slug);
	public List<WatchSpecsWithSale> getAllSale();
	public List<WatchSpecsWithSale> getLastestWatches(int limit);
	public List<WatchSpecsWithSale> search(String name,int limit);
}
