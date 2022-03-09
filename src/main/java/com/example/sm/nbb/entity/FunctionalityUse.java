package com.example.sm.nbb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.CascadeType.DETACH;

/**
 * This class represents the FUNCTIONALITY_USES entity, which determines the level of user's access to data.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FUNCTIONALITY_USES")
public class FunctionalityUse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FUNCTIONALITY_USE_ID", nullable = false)
    private Integer id;

    @OneToOne(cascade = DETACH)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private User user;

    @Column(name = "USE_DATE", nullable = false)
    private LocalDateTime useDate;

    @OneToOne(cascade = DETACH)
    @JoinColumn(name = "FUNCTIONALITY_ID", referencedColumnName = "FUNCTIONALITY_ID")
    private Functionality functionality;
}
