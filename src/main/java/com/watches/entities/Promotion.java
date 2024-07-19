package com.watches.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Promotions")
public class Promotion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="PromotionId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int promotionId;
	@NotEmpty(message = "Promotion Name can not empty")
	@Column(name="PromotionName")
	private String promotionName;
	
	@Column(name="PromotionDesc")
	private String promotionDesc;
	@Column(name="PromotionPicture")
	private String promotionPicture;
	@Column(name="DiscountRate")
	@NotNull(message = "Discount Rate can not empty")
	@Max(value = 100,message = "discount not higher than 100%")
	@Min(value = 0,message = "discount not less than 0%")
	private float discount;
	@NotNull(message = "Start Date can not empty")
	@DateTimeFormat(pattern="dd/MM/yyyy" )
//	@ValidDate
	@Column(name="StartDate")
	private Date  start;
	@NotNull(message = "End Date can not empty")
	@DateTimeFormat(pattern="dd/MM/yyyy")
//	@ValidDate
	@Column(name="EndDate")
	private Date  end;
	public Promotion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Promotion(int promotionId, @NotEmpty(message = "Promotion Name can not empty") String promotionName,
			String promotionDesc, String promotionPicture,
			@NotNull(message = "Discount Rate can not empty") float discount,
			@NotNull(message = "Start Date can not empty") Date start,
			@NotNull(message = "End Date can not empty") Date end) {
		super();
		this.promotionId = promotionId;
		this.promotionName = promotionName;
		this.promotionDesc = promotionDesc;
		this.promotionPicture = promotionPicture;
		this.discount = discount;
		this.start = start;
		this.end = end;
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
	
	
	
}
