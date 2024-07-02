package com.sunbeam.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.dao.RoomDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.RoomRequest;
import com.sunbeam.dto.RoomResponseDto;
import com.sunbeam.entities.Room;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomDao roomDao;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ApiResponse addNewRoom(RoomRequest req) {
        Room room = mapper.map(req, Room.class);
        Room persistRoom = roomDao.save(room);
        return new ApiResponse("New room added with ID=" + persistRoom.getId());
    }
    
    
    
    
    
    
    
    
    
    
    /*Get Available rooms on given check in date
•	Endpoint: GET /rooms/available/{checkInDate}
•	Request: Get all available rooms on given date
•	Response: Return the details of available rooms in JSON format.

*
*/
    
    // select r from reservation r where r.checkout  date 
    
    public List<RoomResponseDto> AvailableRooms(LocalDate date){
    
    	List<RoomResponseDto> rooms = roomDao.findAvailableRooms(date);
    	
    	
    	
		return rooms;
    	
    }
}
