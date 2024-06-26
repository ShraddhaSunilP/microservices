package com.seleniumexpress.addressapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="lane1")
	private String lane1;
	
	@Column(name="lane2")
	private String lane2;
	
	@Column(name="zip")
	private long zip;
	
	@Column(name="state")
	private String state;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int id, String lane1, String lane2, long zip, String state) {
		super();
		this.id = id;
		this.lane1 = lane1;
		this.lane2 = lane2;
		this.zip = zip;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLane1() {
		return lane1;
	}

	public void setLane1(String lane1) {
		this.lane1 = lane1;
	}

	public String getLane2() {
		return lane2;
	}

	public void setLane2(String lane2) {
		this.lane2 = lane2;
	}

	public long getZip() {
		return zip;
	}

	public void setZip(long zip) {
		this.zip = zip;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", lane1=" + lane1 + ", lane2=" + lane2 + ", zip=" + zip + ", state=" + state
				+ "]";
	}

}
