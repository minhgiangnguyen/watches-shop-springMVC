package com.watches.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="OrderDetail")
public class OrderDetail implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="OrderDetailID")
	private int orderDetailId ;
	@Column(name="OrderId")
	private String orderId ;
	@Column(name="WatchID")
	private int watchId ;
	@Column(name="Quantity")
	private int quantity ;
	@Column(name="Price")
	private float price ;
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDetail(int orderDetailId, String orderId, int watchId, int quantity, float price) {
		super();
		this.orderDetailId = orderDetailId;
		this.orderId = orderId;
		this.watchId = watchId;
		this.quantity = quantity;
		this.price = price;
	}
	public OrderDetail(String orderId, int watchId, int quantity, float price) {
		super();
		this.orderId = orderId;
		this.watchId = watchId;
		this.quantity = quantity;
		this.price = price;
	}
	public int getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public int getWatchId() {
		return watchId;
	}
	public void setWatchId(int watchId) {
		this.watchId = watchId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}
