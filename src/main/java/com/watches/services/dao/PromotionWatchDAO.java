package com.watches.services.dao;

import com.watches.entities.PromotionWatch;

public interface PromotionWatchDAO extends GenericDao<PromotionWatch, Integer> {
	public boolean delete(int watchId, int promoId);
}
