package com.example.sm.nbb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * This class represents the ACCESS entity, which determines the level of user's access to data.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ACCESS")
public class Access {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCESS_ID", nullable = false)
    private Integer id;

    @Column(name = "LEVEL", nullable = false)
    private Integer level;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;
}
