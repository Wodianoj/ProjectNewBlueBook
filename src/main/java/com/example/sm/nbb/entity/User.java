package com.example.sm.nbb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.CascadeType.DETACH;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false)
    private Integer id;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "SURNAME", nullable = false)
    private String surname;

    @Column(name = "REGISTRATION_DATE", nullable = false)
    private LocalDateTime registrationDate;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "PHONE", nullable = true)
    private String phone;

    @Column(name = "PASSWORD", nullable = false)
    private byte[] password;

    @OneToOne(cascade = DETACH)
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")
    private Role role;

    @OneToOne(cascade = DETACH)
    @JoinColumn(name = "ACCESS_ID", referencedColumnName = "ACCESS_ID")
    private Access access;
}
