package com.databases.project.AutoServiceManagerAPI.Entity;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Customer {
    @Id
    private int id;
    private String firstName;
    private String LastName;
    private String email;
    private String phoneNumber;
}
