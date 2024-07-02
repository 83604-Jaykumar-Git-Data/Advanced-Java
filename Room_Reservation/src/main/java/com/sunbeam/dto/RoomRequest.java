package com.sunbeam.dto;

import com.sunbeam.entities.Type;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RoomRequest {
    private int roomNo;
    private Type type;
    private double price;
    private boolean availability;
}
