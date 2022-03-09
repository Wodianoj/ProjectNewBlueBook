package com.example.sm.nbb.data;

import com.example.sm.nbb.entity.Access;
import com.example.sm.nbb.entity.Role;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SimpleUser {

    private Integer id;
    private String email;
    private String name;
    private String surname;
    private LocalDateTime registrationDate;
    private String address;
    private String phone;
    private Role role;
    private Access access;
}
