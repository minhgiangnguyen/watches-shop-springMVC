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

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;


@Entity
@NamedNativeQueries({
		@NamedNativeQuery(name = "watchSelectList", 
				query = "EXEC sp_SelectWatches :promoId ", 
				resultClass = WatchSelectPromo.class) })

public class WatchSelectPromo implements Serializable {

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

	public WatchSelectPromo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WatchSelectPromo(int watchId, String watchCode, String watchName, String watchSlug, float price,
			String thumbnail) {
		super();
		this.watchId = watchId;
		this.watchCode = watchCode;
		this.watchName = watchName;
		this.watchSlug = watchSlug;
		this.price = price;
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

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	
	
	
	
	
	

}
