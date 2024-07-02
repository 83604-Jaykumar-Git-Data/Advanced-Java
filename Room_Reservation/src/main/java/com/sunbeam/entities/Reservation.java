package com.sunbeam.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Reservation extends BaseEntity{

	//Reservation ID, guest id, check-in date, check-out date, room ID, total price.\
	
	// res * -> guest
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Guest_id",nullable = false)
	private Guest guest;
	private	LocalDate checkInDate;
	private LocalDate checkOutDate;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Room_id",nullable = false)
	private Room room;
	double totalPrice;
	
	
	
}
