package com.example.sm.nbb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Analysis {
    private Integer id;
    private LocalDateTime registrationDate;
    private String description;
    private String results;
    private Observation observation;
    private User registeredBy;
    private Classification classification;
    private Interpretation interpretation;
}
