package com.example.sm.nbb.filter;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApplicationFilter {

    /**
     * Searches by a fragment of: name, surname, address, email, phone number, or note.
     */
    private String dataFragment;

    private Boolean accepted;
    private Boolean resolved;
    private Boolean rejected;

    private Integer appliedRoleId;
    private Integer appliedAccessId;

    private LocalDateTime submittedAfter;
    private LocalDateTime submittedBefore;
}
