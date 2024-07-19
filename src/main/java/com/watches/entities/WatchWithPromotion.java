package com.watches.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQueries({
		@NamedNativeQuery(name = "watchList", 
				query = "EXEC sp_GetWatchsWithPromotionByPromoId :promoId ", 
				resultClass = WatchWithPromotion.class) })
public class WatchWithPromotion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "WatchID")
	private int watchId;
	@Column(name = "PromotionId")
	private int promoId;
	@Column(name = "WatchName")
	private String watchName;
	@Column(name = "Thumbnail")
	private String thumbnail;
	@Column(name = "Price")
	private float price;
	
	@Column(name = "DiscountRate")
	private float discount;
	@Column(name = "SalePrice")
	private float salePrice;
	public WatchWithPromotion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WatchWithPromotion(int watchId, int promoId, String watchName, String thumbnail, float price, float discount,
			float salePrice) {
		super();
		this.watchId = watchId;
		this.promoId = promoId;
		this.watchName = watchName;
		this.thumbnail = thumbnail;
		this.price = price;
		this.discount = discount;
		this.salePrice = salePrice;
	}
	public int getWatchId() {
		return watchId;
	}
	public void setWatchId(int watchId) {
		this.watchId = watchId;
	}
	public int getPromoId() {
		return promoId;
	}
	public void setPromoId(int promoId) {
		this.promoId = promoId;
	}
	public String getWatchName() {
		return watchName;
	}
	public void setWatchName(String watchName) {
		this.watchName = watchName;
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
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public float getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(float salePrice) {
		this.salePrice = salePrice;
	}
	
	
	
	

}
