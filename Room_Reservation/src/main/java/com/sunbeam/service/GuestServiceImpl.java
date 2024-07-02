package com.sunbeam.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.GuestDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.GuestRequestDto;
import com.sunbeam.dto.RoomRequest;
import com.sunbeam.entities.Guest;
import com.sunbeam.entities.Room;

@Service
@Transactional
public class GuestServiceImpl implements GuestService{
	
	@Autowired
	private GuestDao guestDao;
	
	 @Autowired
	    private ModelMapper mapper;

	
	public ApiResponse addGuest(GuestRequestDto guestReq) {
		

	        Guest guest = mapper.map(guestReq, Guest.class);
	        
	      Guest guest1=  guestDao.save(guest);
	        

	        return new ApiResponse("New room added with ID=" + guest1.getId());
	    }
	

}




	
	
