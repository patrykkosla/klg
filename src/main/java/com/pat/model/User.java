package com.pat.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {	

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name="user_id")
	private long userId;
	
	@Column( name="user_name",nullable = false)
	private String userName; 
	
	@OneToMany(mappedBy="owner")
	@Column( name="owned_facilities")
	private List<Facility> ownedFacilities;
	
	@OneToMany
	@Column( name="user_reservations")
	private List<Reservation> userReservations;	
	
	public User() {}
	
	public User(long userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
