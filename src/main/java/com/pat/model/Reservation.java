package com.pat.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservation")
public class Reservation {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private long id;
	
	@ManyToOne
	private Facility facility;
	
	@ManyToOne
	private User reservedBy;
	
	@Column(name="reserved_from", nullable = false)
	private Date reservedFrom;
	
	@Column(name="reserved_to", nullable = false)
	private Date reservedTo;
	
	@Column(name="reservation_cost", nullable = false)
	private double reservationCost;
	
	
	public Reservation() {}
	public Reservation(long id, Facility facility, User reservedBy, Date reservedFrom, Date reservedTo, double reservationCost) {
		super();
		this.id = id;
		this.facility = facility;
		this.reservedBy = reservedBy;
		this.reservedFrom = reservedFrom;
		this.reservedTo = reservedTo;
		this.reservationCost = reservationCost;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public User getReservedBy() {
		return reservedBy;
	}

	public void setReservedBy(User reservedBy) {
		this.reservedBy = reservedBy;
	}

	public Date getReservedFrom() {
		return reservedFrom;
	}

	public void setReservedFrom(Date reservedFrom) {
		this.reservedFrom = reservedFrom;
	}

	public Date getReservedTo() {
		return reservedTo;
	}

	public void setReservedTo(Date reservedTo) {
		this.reservedTo = reservedTo;
	}
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", facility=" + facility + ", reservedBy=" + reservedBy + ", reservedFrom="
				+ reservedFrom + ", reservedTo=" + reservedTo + "]";
	}
	public double getReservationCost() {
		return reservationCost;
	}
	public void setReservationCost(double reservationCost) {
		this.reservationCost = reservationCost;
	}	
	
	
}
