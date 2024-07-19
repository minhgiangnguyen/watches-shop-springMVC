package com.watches.services.dao;

import java.util.List;

import com.watches.entities.OrderDetail;
import com.watches.entities.OrderWatch;

public interface OrderDao extends GenericDao<OrderWatch, String>{
	public boolean insertOrderDetail(OrderWatch order, List<OrderDetail> details );
	
}
