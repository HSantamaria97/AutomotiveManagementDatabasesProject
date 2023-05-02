package com.databases.project.AutoServiceManagerAPI.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Collection;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "users")
@Table(name = "users", schema = "automotive_service_manager")
public class User {
    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long userId;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="username", unique = true)
    private String username;

    @Column(name ="password")
    private String password;

    private boolean enabled;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name ="repair_id")
    private Collection<Repair> repairs;

    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Role role;

}
