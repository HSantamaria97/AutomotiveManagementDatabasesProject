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
    private int partQuantity;
}
