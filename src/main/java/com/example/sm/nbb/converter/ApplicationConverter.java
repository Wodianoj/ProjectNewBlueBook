package com.example.sm.nbb.converter;

import com.example.sm.nbb.dao.AccessDao;
import com.example.sm.nbb.dao.RoleDao;
import com.example.sm.nbb.data.ApplicationForm;
import com.example.sm.nbb.entity.Application;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ApplicationConverter {

    private final PasswordEncoder passwordEncoder;
    private final AccessDao accessDao;
    private final RoleDao roleDao;

    public ApplicationConverter(PasswordEncoder passwordEncoder, AccessDao accessDao, RoleDao roleDao) {
        this.passwordEncoder = passwordEncoder;
        this.accessDao = accessDao;
        this.roleDao = roleDao;
    }

    public Application convert(final ApplicationForm applicationForm) {
        final Application application = new Application();

        application.setId(application.getId());
        application.setName(applicationForm.getName());
        application.setSurname(applicationForm.getSurname());
        application.setSubmissionDate(LocalDateTime.now());
        application.setAddress(applicationForm.getAddress());
        application.setEmail(applicationForm.getEmail());
        application.setPassword(passwordEncoder.encode(applicationForm.getPassword()).getBytes());
        application.setNote(applicationForm.getNote());
        application.setAppliedRole(roleDao.getById(applicationForm.getAppliedRoleId()));
        application.setAppliedAccess(accessDao.getById(applicationForm.getAppliedAccessId()));

        return application;
    }
}
