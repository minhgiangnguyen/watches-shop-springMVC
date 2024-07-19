package com.watches.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Reviews")
public class Review implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ReviewId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reviewId;
	@Column(name="Rate")
	private int rate;
	@Column(name="Comment")
	private String comment;
	@Column(name="AccountId")
	private int accountId;
	@Column(name="WatchId")
	private int watchId;
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Review(int reviewId, int rate, String comment, int accountId, int watchId) {
		super();
		this.reviewId = reviewId;
		this.rate = rate;
		this.comment = comment;
		this.accountId = accountId;
		this.watchId = watchId;
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getWatchId() {
		return watchId;
	}
	public void setWatchId(int watchId) {
		this.watchId = watchId;
	}
}
