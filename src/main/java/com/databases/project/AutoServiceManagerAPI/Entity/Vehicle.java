package com.databases.project.AutoServiceManagerAPI.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "vehicle", schema = "automotive_service_manager")
public class Vehicle {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="vehicle_id")
    private long vehicleId;
    @Column(name= "year")
    private int year;
    @Column(name = "make")
    private String make;
    @Column(name="model")
    private String model;

}
