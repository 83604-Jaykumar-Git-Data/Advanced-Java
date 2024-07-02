package com.sunbeam.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class GuestRequestDto {

	
	String firstName;
	
	String lastName;
	LocalDate dob;
	
	

}
