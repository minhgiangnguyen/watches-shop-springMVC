package com.watches.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Materials")
public class Material implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int materialId;
	 private String materialName;
	public Material() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Material(int materialId, String materialName) {
		super();
		this.materialId = materialId;
		this.materialName = materialName;
	}
	public int getMaterialId() {
		return materialId;
	}
	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
