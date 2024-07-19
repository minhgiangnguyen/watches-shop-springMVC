package com.watches.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vw_BannersWithExpire")
public class BannerWithExpire implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="BannerId")
	private int bannerId;
	
	@Column(name="BannerName")
	private String bannerName;
	
	@Column(name="BannerDescription")
	private String bannerDesc;
	
	@Column(name="BannerPicture")
    private String picture;
	
	@Column(name="BannerUrl")
	private String bannerUrl;
	
	@Column(name="StartDate")
	private Date start;
	@Column(name="EndDate")
	private Date end;
	
	@Column(name="Expire")
	private boolean expire;
	
	@Column(name="BannerDefault")
	private boolean defaultBanner;
	public BannerWithExpire() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public BannerWithExpire(int bannerId, String bannerName, String bannerDesc, String picture, String bannerUrl,
			Date start, Date end, boolean expire, boolean defaultBanner) {
		super();
		this.bannerId = bannerId;
		this.bannerName = bannerName;
		this.bannerDesc = bannerDesc;
		this.picture = picture;
		this.bannerUrl = bannerUrl;
		this.start = start;
		this.end = end;
		this.expire = expire;
		this.defaultBanner = defaultBanner;
	}

	public boolean isDefaultBanner() {
		return defaultBanner;
	}



	public void setDefaultBanner(boolean defaultBanner) {
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

	public boolean isExpire() {
		return expire;
	}

	public void setExpire(boolean expire) {
		this.expire = expire;
	}

	@Override
	public String toString() {
		return "BannerWithExpire [bannerId=" + bannerId + ", bannerName=" + bannerName + ", bannerDesc=" + bannerDesc
				+ ", picture=" + picture + ", bannerUrl=" + bannerUrl + ", start=" + start + ", end=" + end
				+ ", expire=" + expire + "]";
	}

	
	
	
	
	
}
