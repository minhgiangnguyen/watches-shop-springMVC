package com.watches.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="StrapTypes")
public class StrapType implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int strapTypeId;
    private String strapName;
	public StrapType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StrapType(int strapTypeId, String strapName) {
		super();
		this.strapTypeId = strapTypeId;
		this.strapName = strapName;
	}
	public int getStrapTypeId() {
		return strapTypeId;
	}
	public void setStrapTypeId(int strapTypeId) {
		this.strapTypeId = strapTypeId;
	}
	public String getStrapName() {
		return strapName;
	}
	public void setStrapName(String strapName) {
		this.strapName = strapName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
