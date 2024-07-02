package com.sunbeam.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dao.GuestDao;
import com.sunbeam.dao.ReservationDao;
import com.sunbeam.dao.RoomDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.ReservationRequestDto;
import com.sunbeam.dto.RoomResponseDto;
import com.sunbeam.entities.Guest;
import com.sunbeam.entities.Reservation;
import com.sunbeam.entities.Room;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationDao reservationDao;

    @Autowired
    private RoomDao roomDao;

    @Autowired
    private GuestDao guestDao;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ApiResponse reserveRoom(ReservationRequestDto dto) {
        Room room = roomDao.findById(dto.getRoomId())
                .orElseThrow(() -> new ResourceNotFoundException("Invalid room id !!!!"));

        Guest guest = guestDao.findByFirstName(dto.getFirstName())
                .orElseThrow(() -> new ResourceNotFoundException("Invalid guest name !!!!"));
if(room.isAvailability()) {
        Reservation reservation = mapper.map(dto, Reservation.class);
        long days = ChronoUnit.DAYS.between(dto.getCheckInDate(), dto.getCheckOutDate());
        double price = room.getPrice() * days;
        

        reservation.setGuest(guest);
        reservation.setRoom(room);
        reservation.setTotalPrice(price);

        reservationDao.save(reservation);
       room.setAvailability(false);
        return new ApiResponse("Reservation is successful. Details are given: " + reservation);
    }
else{
	}return new ApiResponse("room  is not available. Details are given: " );
}
    
    
    
    
    
 
    
    public ApiResponse deleteReservation(Long Id) {
    	
    	
    Reservation reservation1=reservationDao.findById(Id) 
    		.orElseThrow(() -> new ResourceNotFoundException("Invalid room id !!!!"));
    
   
    
             reservation1.getRoom().setAvailability(true);
             
    	
    	
    	
   return new ApiResponse("Reservation is successful cancel .  " + reservation1.getId());
    	
    	
    }
    
    
    
    
    
    
   
    
    
    
    
    
    
    
    
}
