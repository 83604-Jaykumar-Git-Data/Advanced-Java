package com.sunbeam.service;

import java.time.LocalDate;
import java.util.List;

import com.sunbeam.custom_exceptions.ApiException;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.ReservationRequestDto;
import com.sunbeam.dto.RoomResponseDto;

public interface ReservationService {
	
	public ApiResponse reserveRoom(ReservationRequestDto dto);
	 public ApiResponse deleteReservation(Long Id);
	   
	   

}
