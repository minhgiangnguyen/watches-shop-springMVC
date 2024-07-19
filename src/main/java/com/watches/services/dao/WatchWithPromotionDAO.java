package com.watches.services.dao;

import java.util.List;

import com.watches.entities.WatchWithPromotion;

public interface WatchWithPromotionDAO extends GenericDao<WatchWithPromotionDAO, Integer> {
	public List<WatchWithPromotion> getWatchsPromotionByPromoId(int promoId);
}
