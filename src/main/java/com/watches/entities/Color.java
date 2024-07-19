package com.watches.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
@Entity
@Table(name="Colors")
public class Color implements Serializable{

	private static final long serialVersionUID = 1L;
    
	@Id
	@Column(name="ColorID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int colorId;
    @NotEmpty(message = "Color can not empty")
	@Column(name="ColorValue")
	private String colorValue;
	public Color() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Color(int colorId, @NotEmpty(message = "Color can not empty") String colorValue) {
		super();
		this.colorId = colorId;
		this.colorValue = colorValue;
	}
	public int getColorId() {
		return colorId;
	}
	public void setColorId(int colorId) {
		this.colorId = colorId;
	}
	public String getColorValue() {
		return colorValue;
	}
	public void setColorValue(String colorValue) {
		this.colorValue = colorValue;
	}
	
}
