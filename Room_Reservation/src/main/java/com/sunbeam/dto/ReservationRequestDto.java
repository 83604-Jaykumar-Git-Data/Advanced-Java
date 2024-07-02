package com.sunbeam.dto;

import java.time.LocalDate;

import com.sunbeam.entities.Guest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class ReservationRequestDto {

	
	
	String firstName;
	Long roomId;
	private	LocalDate checkInDate;
	private LocalDate checkOutDate;
	
}
