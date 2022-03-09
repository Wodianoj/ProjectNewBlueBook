package com.example.sm.nbb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "OBSERVERS")
public class Observer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OBSERVER_ID", nullable = false)
    private Integer id;

    @Column(name = "NAME", nullable = true)
    private String name;

    @Column(name = "SURNAME", nullable = true)
    private String surname;

    @Column(name = "ALIAS", nullable = true)
    private String alias;

    @Column(name = "ADDRESS", nullable = true)
    private String address;

    @Column(name = "CONTACT", nullable = true)
    private String contact;

    @Column(name = "PHOTO", nullable = true)
    private String photo;

    @Column(name = "DESCRIPTION", nullable = true)
    private String description;
}
