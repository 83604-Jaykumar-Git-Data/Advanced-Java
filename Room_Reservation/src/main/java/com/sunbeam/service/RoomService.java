package com.sunbeam.service;

import java.time.LocalDate;
import java.util.List;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.RoomRequest;
import com.sunbeam.dto.RoomResponseDto;

public interface RoomService {

	public ApiResponse addNewRoom(RoomRequest req);
	 public List<RoomResponseDto> AvailableRooms(LocalDate date);
	 
	
	
}
