package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.ReservationRequestDto;
import com.sunbeam.dto.RoomRequest;
import com.sunbeam.service.ReservationService;
import com.sunbeam.service.RoomService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;

	public ReservationController() {
		System.out.println("in controller reservation");
	}

	@PostMapping
	public ResponseEntity<?> addReservation(@RequestBody ReservationRequestDto dto) {
		System.out.println("in add Room " + dto);
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.reserveRoom(dto));
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));

		}
	}
	
	/*@GetMapping("/{catId}")
	public ResponseEntity<?> getCategoryDetails(@PathVariable Long catId) {
		System.out.println("in get category " + catId);
		try {
			// invoke service layer method
			return ResponseEntity.ok(categoryService.getCategoryDetails(catId));
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}*/
	
	
	@DeleteMapping("/{revId}")
	public ResponseEntity<?> deleteReservation(@PathVariable Long revId) {
		System.out.println("delete reseration " );
		try {
			return ResponseEntity.ok(reservationService.deleteReservation(revId));
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));

		}
	}
	
	

}
