package com.watches.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;



@Entity
@Table(name="WatchSpecs")
//@NamedNativeQueries({
//    @NamedNativeQuery(
//    name = "WatchPaginate",
//    query = "EXEC WatchPaginate :limit,:page ",
//    resultClass = WatchSpecs.class
//    )
//})

public class WatchSpecs implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="WatchID")
	private int watchId;
	@Column(name="WatchCode")
	private String watchCode;
	@Column(name="WatchName")
	private String watchName;
	@Column(name="WatchSlug")
	private String watchSlug;
	@Column(name="Price")
	private float price;
	@Column(name="GenderName")
	private String gender;
	@Column(name="BrandName")
	private String brand ;
	@Column(name="ColorValue")
	private String color ;
	@Column(name="Thumbnail")
	private String thumbnail;
	
	public WatchSpecs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WatchSpecs(int watchId, String watchCode, String watchName, String watchSlug, float price, String gender,
			String brand, String color, String thumbnail) {
		super();
		this.watchId = watchId;
		this.watchCode = watchCode;
		this.watchName = watchName;
		this.watchSlug = watchSlug;
		this.price = price;
		this.gender = gender;
		this.brand = brand;
		this.color = color;
		this.thumbnail = thumbnail;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	
}
