package com.databases.project.AutoServiceManagerAPI.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "parts", schema = "automotive_service_manager")
public class Parts {
    @Id
    @Column(name = "part_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long partId;
    @Column(name = "part_number")
    private String partNumber;
    @Column(name = "part_name")
    private String partName;
    @Column(name = "part_quantity")
    private String partQuantity;
    @Column(name = "part_price")
    private double partPrice;
}
