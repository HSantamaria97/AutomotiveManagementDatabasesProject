package com.databases.project.AutoServiceManagerAPI.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="vehicle")
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
