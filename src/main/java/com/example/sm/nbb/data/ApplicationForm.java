package com.example.sm.nbb.data;

import lombok.Data;

@Data
public class ApplicationForm {

    private Integer id;
    private Integer appliedRoleId;
    private Integer appliedAccessId;

    private String email;
    private String name;
    private String surname;
    private String address;
    private String phone;
    private String password;
    private String note;
}
