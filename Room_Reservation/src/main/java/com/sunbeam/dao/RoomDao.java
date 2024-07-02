package com.sunbeam.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sunbeam.dto.RoomResponseDto;
import com.sunbeam.entities.Room;

public interface RoomDao extends JpaRepository<Room, Long> {
	
	@Query("SELECT new com.sunbeam.dto.RoomResponseDto(r.roomNo, r.type, r.price, r.availability) " +
           "FROM Room r " +
           "WHERE r.availability = true " +
           "AND r.id NOT IN (SELECT res.room.id FROM Reservation res " +
           "WHERE :checkInDate BETWEEN res.checkInDate AND res.checkOutDate)")
	List<RoomResponseDto> findAvailableRooms(@Param("checkInDate") LocalDate checkInDate);
}
