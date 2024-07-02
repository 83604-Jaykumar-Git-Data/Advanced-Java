package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.GuestRequestDto;
import com.sunbeam.service.GuestService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/Guest")
public class GuestController {
	
	@Autowired
	private GuestService guestService;

	@PostMapping
	public ResponseEntity<?> addGuest(@RequestBody GuestRequestDto dto) {
		System.out.println("in add Guest  " + dto);
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(guestService.addGuest(dto));
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ApiResponse(e.getMessage()));
		}
	}
}
