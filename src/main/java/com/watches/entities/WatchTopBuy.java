package com.watches.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vw_WatchesTopBy")
public class WatchTopBuy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="WatchId")
	private int watchId;
	@Column(name="WatchName")
	private String watchName;
	@Column(name="WatchSlug")
	private String watchSlug;
	@Column(name="Thumbnail")
	private String thumbnail;
	@Column(name="Price")
	private float price;
	@Column(name="SalePrice")
	private float salePrice;
	@Column(name="HaveSale")
	private boolean haveSale;
	@Column(name="countWatch")
	private int countWatch;
	
	public WatchTopBuy() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public WatchTopBuy(int watchId, String watchName, String watchSlug, String thumbnail, float price, float salePrice,
			boolean haveSale, int countWatch) {
		super();
		this.watchId = watchId;
		this.watchName = watchName;
		this.watchSlug = watchSlug;
		this.thumbnail = thumbnail;
		this.price = price;
		this.salePrice = salePrice;
		this.haveSale = haveSale;
		this.countWatch = countWatch;
	}
	public int getWatchId() {
		return watchId;
	}
	public void setWatchId(int watchId) {
		this.watchId = watchId;
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
	public float getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(float salePrice) {
		this.salePrice = salePrice;
	}
	public boolean isHaveSale() {
		return haveSale;
	}
	public void setHaveSale(boolean haveSale) {
		this.haveSale = haveSale;
	}
	public int getCountWatch() {
		return countWatch;
	}
	public void setCountWatch(int countWatch) {
		this.countWatch = countWatch;
	}
	
	
	
}
