package com.pat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
		
//		@OneToMany(mappedBy="facility")
//		private List<Reservation> reservations;
//		
//		@ManyToOne
//		//@JoinColumn(name = "id", nullable = false)
//		private User owner;
		
		public Facility() {}
		
	}
