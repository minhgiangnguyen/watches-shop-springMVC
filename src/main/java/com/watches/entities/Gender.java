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
@Table(name="Genders")
public class Gender implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="GenderId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int genderId;
	@Column(name="GenderName")
	@NotEmpty(message = "Gender Name can not empty")
	private String genderName;
	@Column(name="GenderPicture")
    private String genderPicture;
	public Gender() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Gender(int genderId, @NotEmpty(message = "Gender Name can not empty") String genderName,
			String genderPicture) {
		super();
		this.genderId = genderId;
		this.genderName = genderName;
		this.genderPicture = genderPicture;
	}

	public int getGenderId() {
		return genderId;
	}
	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}
	public String getGenderName() {
		return genderName;
	}
	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}
	public String getGenderPicture() {
		return genderPicture;
	}
	public void setGenderPicture(String genderPicture) {
		this.genderPicture = genderPicture;
	}
	
}
