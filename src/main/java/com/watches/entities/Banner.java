package com.watches.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="Banners")
public class Banner implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="BannerId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bannerId;
	@NotEmpty(message = "Banner Name can not empty")
	@Column(name="BannerName")
	private String bannerName;
	@NotEmpty(message = "Banner Description can not empty")
	@Column(name="BannerDescription")
	private String bannerDesc;
	
	@Column(name="BannerPicture")
    private String picture;
	
	@NotEmpty(message = "Banner Url can not empty")
	@Column(name="BannerUrl")
	private String bannerUrl;
	
	@Column(name="StartDate")
//	@NotNull(message = "Start Date can not empty")
	@DateTimeFormat(pattern="dd/MM/yyyy" )
	private Date start;
//	@NotNull(message = "End Date can not empty")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="EndDate")
	private Date end;
	
	@Column(name="BannerDefault")
	private boolean defaultBanner;
	
	
	public Banner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Banner(int bannerId, @NotEmpty(message = "Banner Name can not empty") String bannerName,
			@NotEmpty(message = "Banner Description can not empty") String bannerDesc, String picture,
			@NotEmpty(message = "Banner Url can not empty") String bannerUrl,
			@NotNull(message = "Start Date can not empty") Date start,
			@NotNull(message = "End Date can not empty") Date end, boolean defaultBanner) {
		super();
		this.bannerId = bannerId;
		this.bannerName = bannerName;
		this.bannerDesc = bannerDesc;
		this.picture = picture;
		this.bannerUrl = bannerUrl;
		this.start = start;
		this.end = end;
		this.defaultBanner = defaultBanner;
	}

	public int getBannerId() {
		return bannerId;
	}

	public void setBannerId(int bannerId) {
		this.bannerId = bannerId;
	}

	public String getBannerName() {
		return bannerName;
	}

	public void setBannerName(String bannerName) {
		this.bannerName = bannerName;
	}

	public String getBannerDesc() {
		return bannerDesc;
	}

	public void setBannerDesc(String bannerDesc) {
		this.bannerDesc = bannerDesc;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getBannerUrl() {
		return bannerUrl;
	}

	public void setBannerUrl(String bannerUrl) {
		this.bannerUrl = bannerUrl;
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

	public boolean isDefaultBanner() {
		return defaultBanner;
	}

	public void setDefaultBanner(boolean defaultBanner) {
		this.defaultBanner = defaultBanner;
	}

	
	
	
}
