package com.sunbeam.dto;

import com.sunbeam.entities.Type;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RoomResponseDto {
    private int roomNo;
    private Type type;
    private double price;
    private boolean availability;

    // Add a constructor for the selected fields
    public RoomResponseDto(int roomNo, Type type, double price, boolean availability) {
        this.roomNo = roomNo;
        this.type = type;
        this.price = price;
        this.availability = availability;
    }
}
