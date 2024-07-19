package com.watches.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="PromotionWatchs")
public class PromotionWatch implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="PromoWatchId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int promoWatchId;
	@Column(name="PromotionId")
	private int promoId;
	@Column(name="WatchId")
	private int watchId;
	public PromotionWatch() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	

	public PromotionWatch(int promoWatchId, int promoId, int watchId) {
		super();
		this.promoWatchId = promoWatchId;
		this.promoId = promoId;
		this.watchId = watchId;
	}

	public int getPromoWatchId() {
		return promoWatchId;
	}
	public void setPromoWatchId(int promoWatchId) {
		this.promoWatchId = promoWatchId;
	}
	public int getPromoId() {
		return promoId;
	}
	public void setPromoId(int promoId) {
		this.promoId = promoId;
	}
	public int getWatchId() {
		return watchId;
	}
	public void setWatchId(int watchId) {
		this.watchId = watchId;
	}
	
	
}
