package com.sunbeam.dao;


import com.sunbeam.entities.Reservation;
import com.sunbeam.entities.Room;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReservationDao extends JpaRepository<Reservation, Long> {

	
}
