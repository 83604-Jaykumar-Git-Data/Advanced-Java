package com.sunbeam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "room")
public class Room extends BaseEntity {

    @Column(name = "room_no")
    private int roomNo;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "price")
    private double price;

    @Column(name = "availability")
    private boolean availability;
}
