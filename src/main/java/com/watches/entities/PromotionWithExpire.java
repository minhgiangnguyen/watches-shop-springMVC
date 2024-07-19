package com.watches.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vw_PromotionsWithExpire")
public class PromotionWithExpire implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="PromotionId")
	private int promotionId;
	@Column(name="PromotionName")
	private String promotionName;
	
	@Column(name="PromotionDesc")
	private String promotionDesc;
	@Column(name="PromotionPicture")
	private String promotionPicture;
	@Column(name="DiscountRate")
	private float discount;
	@Column(name="StartDate")
	private Date  start;
	@Column(name="EndDate")
	private Date  end;
	@Column(name="Expire")
	private boolean expire;
	public PromotionWithExpire(int promotionId, String promotionName, String promotionDesc, String promotionPicture,
			float discount, Date start, Date end, boolean expire) {
		super();
		this.promotionId = promotionId;
		this.promotionName = promotionName;
		this.promotionDesc = promotionDesc;
		this.promotionPicture = promotionPicture;
		this.discount = discount;
		this.start = start;
		this.end = end;
		this.expire = expire;
	}
	public PromotionWithExpire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPromotionId() {
		return promotionId;
	}
	public void setPromotionId(int promotionId) {
		this.promotionId = promotionId;
	}
	public String getPromotionName() {
		return promotionName;
	}
	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}
	public String getPromotionDesc() {
		return promotionDesc;
	}
	public void setPromotionDesc(String promotionDesc) {
		this.promotionDesc = promotionDesc;
	}
	public String getPromotionPicture() {
		return promotionPicture;
	}
	public void setPromotionPicture(String promotionPicture) {
		this.promotionPicture = promotionPicture;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public boolean isExpire() {
		return expire;
	}
	public void setExpire(boolean expire) {
		this.expire = expire;
	}
	
	
}
