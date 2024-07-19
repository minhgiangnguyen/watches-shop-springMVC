package com.watches.services.dao;

import java.util.List;

import com.watches.entities.WatchTopBuy;

public interface WatchTopBuyDAO extends GenericDao<WatchTopBuy, Integer> {
	public List<WatchTopBuy> getLimit(int limit);
}
