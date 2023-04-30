package com.databases.project.AutoServiceManagerAPI.Entity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customer", schema = "AutomotiveServiceManager")
public class Customer {
    @Id
    @Column(name="customer_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long customerId;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String LastName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
}
