package com.watches.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Sizes")
public class Sizes implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int sizeId;
	 private int sizeValue;
	public Sizes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sizes(int sizeId, int sizeValue) {
		super();
		this.sizeId = sizeId;
		this.sizeValue = sizeValue;
	}
	public int getSizeId() {
		return sizeId;
	}
	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}
	public int getSizeValue() {
		return sizeValue;
	}
	public void setSizeValue(int sizeValue) {
		this.sizeValue = sizeValue;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	 
}
