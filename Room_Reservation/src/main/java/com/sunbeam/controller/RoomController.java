package com.sunbeam.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.RoomRequest;
import com.sunbeam.service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	public RoomController() {
		System.out.println("room controller in ");
	}
	
	@PostMapping
	public ResponseEntity<?> addRoom(@RequestBody RoomRequest dto) {
		System.out.println("in add Room " + dto);
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(roomService.addNewRoom(dto));
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ApiResponse(e.getMessage()));
		}
	}

	/* Get Available rooms on given check in date
	 * Endpoint: GET /rooms/available/{checkInDate}
	 * Request: Get all available rooms on given date
	 * Response: Return the details of available rooms in JSON format.
	 */
	@GetMapping("/available/{date}")
	public ResponseEntity<?> getList(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		try {
			return ResponseEntity.ok(roomService.AvailableRooms(date));
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ApiResponse(e.getMessage()));
		}
	}
}
