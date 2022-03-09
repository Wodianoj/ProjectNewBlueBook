package com.example.sm.nbb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * This class represents the FUNCTIONALITIES entity, which determines the level of user's access to data.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FUNCTIONALITIES")
public class Functionality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FUNCTIONALITY_ID", nullable = false)
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;
}
