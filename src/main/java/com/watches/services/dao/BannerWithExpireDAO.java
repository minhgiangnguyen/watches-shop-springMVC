package com.watches.services.dao;

import com.watches.entities.BannerWithExpire;

public interface BannerWithExpireDAO extends GenericDao<BannerWithExpire, Integer> {
	public BannerWithExpire get();
}
