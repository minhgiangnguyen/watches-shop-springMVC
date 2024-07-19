package com.watches.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Movements")
public class Movements implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movementId;
    private String movementName;
	public Movements() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movements(int movementId, String movementName) {
		super();
		this.movementId = movementId;
		this.movementName = movementName;
	}
	public int getMovementId() {
		return movementId;
	}
	public void setMovementId(int movementId) {
		this.movementId = movementId;
	}
	public String getMovementName() {
		return movementName;
	}
	public void setMovementName(String movementName) {
		this.movementName = movementName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
