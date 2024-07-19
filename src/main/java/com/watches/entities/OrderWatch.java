package com.watches.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="OrderWatch")
public class OrderWatch implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="OrderId")
	private String orderId ;
	@Column(name="OrderDate")
	private Date orderDate ;
	@Column(name="AccountId")
	private String accountId ;
	@Column(name="ReceiveAddress")
	private String receiveAddress ;
	
	@Column(name="ReceivePhone")
	private String receivePhone ;
	
	@Column(name="ReceiveDate")
	private Date receiveDate ;
	
	@Column(name="Note")
	private String note ;
	
	@Column(name="Status")
	private boolean status;

	public OrderWatch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderWatch(String orderId, Date orderDate, String accountId, String receiveAddress, String receivePhone,
			Date receiveDate, String note, boolean status) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.accountId = accountId;
		this.receiveAddress = receiveAddress;
		this.receivePhone = receivePhone;
		this.receiveDate = receiveDate;
		this.note = note;
		this.status = status;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getReceiveAddress() {
		return receiveAddress;
	}

	public void setReceiveAddress(String receiveAddress) {
		this.receiveAddress = receiveAddress;
	}

	public String getReceivePhone() {
		return receivePhone;
	}

	public void setReceivePhone(String receivePhone) {
		this.receivePhone = receivePhone;
	}

	public Date getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
