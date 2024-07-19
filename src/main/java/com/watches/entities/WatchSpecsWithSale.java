package com.watches.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="vw_WatchSpecsWithSale")
public class WatchSpecsWithSale implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="WatchId")
	private int watchId;
	@Column(name="WatchCode")
	private String watchCode;
	@Column(name="WatchName")
	private String watchName;
	@Column(name="WatchSlug")
	private String watchSlug;
	@Column(name="Price")
	private float price;
	
	@Column(name="Thumbnail")
	private String thumbnail;
	@Column(name="PictureList")
	private String pictureList;
	
	@Column(name="GenderName")
	private String genderName;
	@Column(name="BrandName")
	private String brandName ;
	@Column(name="ColorValue")
	private String colorValue ;
	@Column(name="StrapName")
	private String strapName;
	@Column(name="SizeValue")
	private int sizeValue;
	@Column(name="MovementName")
	private String movementName;
	@Column(name="MaterialName")
	private String materialName;
	@Column(name="Description")
	private String description;
	@Column(name="CreateDate")
	private Date create;
	@Column(name="UpdateDate")
	private Date update;
	@Column(name="SalePrice")
	private float salePrice;
	@Column(name="HaveSale")
	private boolean haveSale;
	@Column(name="DiscountRate")
	private float discount;
	public WatchSpecsWithSale() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WatchSpecsWithSale(int watchId, String watchCode, String watchName, String watchSlug, float price,
			String thumbnail, String pictureList, String genderName, String brandName, String colorValue,
			String strapName, int sizeValue, String movementName, String materialName, String description, Date create,
			Date update, float salePrice, boolean haveSale, float discount) {
		super();
		this.watchId = watchId;
		this.watchCode = watchCode;
		this.watchName = watchName;
		this.watchSlug = watchSlug;
		this.price = price;
		this.thumbnail = thumbnail;
		this.pictureList = pictureList;
		this.genderName = genderName;
		this.brandName = brandName;
		this.colorValue = colorValue;
		this.strapName = strapName;
		this.sizeValue = sizeValue;
		this.movementName = movementName;
		this.materialName = materialName;
		this.description = description;
		this.create = create;
		this.update = update;
		this.salePrice = salePrice;
		this.haveSale = haveSale;
		this.discount = discount;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getPictureList() {
		return pictureList;
	}
	public void setPictureList(String pictureList) {
		this.pictureList = pictureList;
	}
	public String getGenderName() {
		return genderName;
	}
	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getColorValue() {
		return colorValue;
	}
	public void setColorValue(String colorValue) {
		this.colorValue = colorValue;
	}
	public String getStrapName() {
		return strapName;
	}
	public void setStrapName(String strapName) {
		this.strapName = strapName;
	}
	public int getSizeValue() {
		return sizeValue;
	}
	public void setSizeValue(int sizeValue) {
		this.sizeValue = sizeValue;
	}
	public String getMovementName() {
		return movementName;
	}
	public void setMovementName(String movementName) {
		this.movementName = movementName;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreate() {
		return create;
	}
	public void setCreate(Date create) {
		this.create = create;
	}
	public Date getUpdate() {
		return update;
	}
	public void setUpdate(Date update) {
		this.update = update;
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
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	
	
}
