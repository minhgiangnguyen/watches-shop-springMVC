package com.watches.services.dao;

import java.util.List;

import com.watches.entities.WatchSelectPromo;

public interface WatchSelectPromoDAO extends GenericDao<WatchSelectPromo, Integer> {
	public List<WatchSelectPromo> getWatchesSelect(int promoId);
}
