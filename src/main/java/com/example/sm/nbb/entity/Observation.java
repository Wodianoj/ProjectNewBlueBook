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
/*@Entity
@Table(name = "OBSERVATIONS")*/
public class Observation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OBSERVATION_ID", nullable = false)
    private Integer id;

    @Column(name = "OBSERVATION_DATE", nullable = false)
    private LocalDateTime observationDate;

    private Coordinates coordinates;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "PATH_TO_MATERIALS", nullable = false)
    private String pathToMaterials;

    @OneToOne(cascade = DETACH)
    @JoinColumn(name = "ACCESS_ID", referencedColumnName = "ACCESS_ID")
    private Access access;
}
