package com.pat.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="facilities")
public class Facility {
		
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private long id;
	
	@Column( name="facility_name",nullable = false)
	private String facilityName;
	
	@Column(name="price_per_day", nullable = false)
	private double pricePerDay;
	
	@Column(name="property_area")
	private double propertyArea;
	
	private String descryption; 	
	
	@OneToMany(mappedBy="facility")
	private List<Reservation> reservations;
	
	@ManyToOne
	private User owner;
	
	
	public Facility() {}
	
	public Facility(long id, String facilityName, double pricePerDay, double propertyArea, String descryption,
			User owner) {
		super();
		this.id = id;
		this.facilityName = facilityName;
		this.pricePerDay = pricePerDay;
		this.propertyArea = propertyArea;
		this.descryption = descryption;
		this.owner = owner;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public double getPropertyArea() {
		return propertyArea;
	}

	public void setPropertyArea(double propertyArea) {
		this.propertyArea = propertyArea;
	}

	public String getDescryption() {
		return descryption;
	}

	public void setDescryption(String descryption) {
		this.descryption = descryption;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}	
}
