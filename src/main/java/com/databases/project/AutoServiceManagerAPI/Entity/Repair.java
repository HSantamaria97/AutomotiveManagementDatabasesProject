package com.databases.project.AutoServiceManagerAPI.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "repair")
@Table(name = "repair", schema = "automotive_service_manager")
public class Repair {
    @Id
    @Column(name = "repair_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long repairId;

    @Column(name = "repair_description")
    private String repairDescription;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="vehicle_id")
    private Vehicle vehicle;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "part_id")
    private Collection<Parts> parts;

    @CreationTimestamp
    private Date repairDate;

    @Column(name = "completed")
    private boolean completed = false;
}
