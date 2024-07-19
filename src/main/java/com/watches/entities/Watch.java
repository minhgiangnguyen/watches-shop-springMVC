package com.watches.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="Watchs")

public class Watch implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="WatchId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int watchId;
	@NotEmpty(message = "Watch Code can not empty")
	@Column(name="WatchCode")
	private String watchCode;
	@NotEmpty(message = "Watch Name can not empty")
	@Column(name="WatchName")
	private String watchName;
	@Column(name="WatchSlug")
	private String watchSlug;
	@NotNull(message = "Price can not empty")
	@Column(name="Price")
	private float price;
	
	@Column(name="Thumbnail")
	private String thumbnail;
	@Column(name="PictureList")
	private String pictureList;
	
	@NotNull(message = "Please choose Gender")
	@Column(name="GenderID")
	private int genderId;
	@NotNull(message = "Please choose Brand ")
	@Column(name="BrandID")
	private int brandId ;
	@NotNull(message = "Please choose Color")
	@Column(name="ColorID")
	private int colorId ;
	@Column(name="StrapTypeId")
	private int strapTypeId;
	@Column(name="SizeId")
	private int sizeId;
	@Column(name="MovementId")
	private int movementId;
	@Column(name="MaterialId")
	private int materialId;
	
	@NotEmpty(message = "Description can not empty")
	@Column(name="Description")
	private String description;
	
	@Column(name="CreateDate")
	private Date create;
	@Column(name="UpdateDate")
	private Date update;
	public Watch() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Watch(int watchId, @NotEmpty(message = "Watch Code can not empty") String watchCode,
			@NotEmpty(message = "Watch Name can not empty") String watchName, String watchSlug,
			@NotNull(message = "Price can not empty") float price, String thumbnail, String pictureList,
			@NotNull(message = "Please choose Gender") int genderId,
			@NotNull(message = "Please choose Brand ") int brandId,
			@NotNull(message = "Please choose Color") int colorId, int strapTypeId, int sizeId, int movementId,
			int materialId, @NotEmpty(message = "Description can not empty") String description, Date create,
			Date update) {
		super();
		this.watchId = watchId;
		this.watchCode = watchCode;
		this.watchName = watchName;
		this.watchSlug = watchSlug;
		this.price = price;
		this.thumbnail = thumbnail;
		this.pictureList = pictureList;
		this.genderId = genderId;
		this.brandId = brandId;
		this.colorId = colorId;
		this.strapTypeId = strapTypeId;
		this.sizeId = sizeId;
		this.movementId = movementId;
		this.materialId = materialId;
		this.description = description;
		this.create = create;
		this.update = update;
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
	public int getGenderId() {
		return genderId;
	}
	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public int getColorId() {
		return colorId;
	}
	public void setColorId(int colorId) {
		this.colorId = colorId;
	}
	public int getStrapTypeId() {
		return strapTypeId;
	}
	public void setStrapTypeId(int strapTypeId) {
		this.strapTypeId = strapTypeId;
	}
	public int getSizeId() {
		return sizeId;
	}
	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}
	public int getMovementId() {
		return movementId;
	}
	public void setMovementId(int movementId) {
		this.movementId = movementId;
	}
	public int getMaterialId() {
		return materialId;
	}
	public void setMaterialId(int materialId) {
		this.materialId = materialId;
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
	
	
	
	
	

}
