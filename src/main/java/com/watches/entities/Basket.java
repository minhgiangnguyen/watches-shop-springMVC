package com.watches.entities;

import java.io.Serializable;

public class Basket implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int watchId;
	private String watchCode;
	private String watchName;
	private String watchSlug;
	private String thumbnail;
	private float price;
	private int quantity;
	public Basket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Basket(int watchId, String watchCode, String watchName, String watchSlug, String thumbnail, float price,
			int quantity) {
		super();
		this.watchId = watchId;
		this.watchCode = watchCode;
		this.watchName = watchName;
		this.watchSlug = watchSlug;
		this.thumbnail = thumbnail;
		this.price = price;
		this.quantity = quantity;
	}
	public int getWatchId() {
		return watchId;
	}
	public void setWatchId(int watchId) {
		this.watchId = watchId;
	}
	public String getWatchCode() {
		return watchCode;
	}
	public void setWatchCode(String watchCode) {
		this.watchCode = watchCode;
	}
	public String getWatchName() {
		return watchName;
	}
	public void setWatchName(String watchName) {
		this.watchName = watchName;
	}
	public String getWatchSlug() {
		return watchSlug;
	}
	public void setWatchSlug(String watchSlug) {
		this.watchSlug = watchSlug;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
