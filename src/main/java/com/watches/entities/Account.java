package com.watches.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Accounts")
public class Account implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
    private String accountId;
	@NotEmpty(message = "Full name cannot be empty")
	private String fullName;
	@NotEmpty(message = "User name cannot be empty")
	private String userName;
	@NotEmpty(message = "Password cannot be empty")
	private String password;
	private String avatar;
	@NotEmpty(message = "Email cannot be empty")
	private String email;
	@NotEmpty(message = "Phone cannot be empty")
	private String phone;
	@NotEmpty(message = "Address cannot be empty")
	private String address;
	private boolean role;
	private boolean gender;
	private boolean active;
	@NotNull(message = "Please enter your date of birth")
	private Date createDate;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(String accountId, @NotEmpty(message = "Full name cannot be empty") String fullName,
			@NotEmpty(message = "User name cannot be empty") String userName,
			@NotEmpty(message = "Password cannot be empty") String password, String avatar,
			@NotEmpty(message = "Email cannot be empty") String email,
			@NotEmpty(message = "Phone cannot be empty") String phone,
			@NotEmpty(message = "Address cannot be empty") String address, boolean role, boolean gender, boolean active,
			@NotNull(message = "Please enter your date of birth") Date createDate) {
		super();
		this.accountId = accountId;
		this.fullName = fullName;
		this.userName = userName;
		this.password = password;
		this.avatar = avatar;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.role = role;
		this.gender = gender;
		this.active = active;
		this.createDate = createDate;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isRole() {
		return role;
	}
	public void setRole(boolean role) {
		this.role = role;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
}
