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
@Entity(name ="customer")
@Table(name = "customer", schema = "AutomotiveServiceManager")
public class Customer {
    @Id
    @Column(name="customer_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long customerId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;
}
