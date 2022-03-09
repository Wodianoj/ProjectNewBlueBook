package com.example.sm.nbb.controller;

import com.example.sm.nbb.converter.ApplicationConverter;
import com.example.sm.nbb.dao.AccessDao;
import com.example.sm.nbb.dao.ApplicationDao;
import com.example.sm.nbb.dao.RoleDao;
import com.example.sm.nbb.data.ApplicationForm;
import com.example.sm.nbb.entity.Application;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class RegisterController {

    private final RoleDao roleDao;
    private final AccessDao accessDao;
    private final ApplicationDao applicationDao;
    private final ApplicationConverter applicationConverter;

    @Autowired
    public RegisterController(final RoleDao roleDao,
                              final AccessDao accessDao,
                              final ApplicationDao applicationDao,
                              final ApplicationConverter applicationConverter) {
        this.roleDao = roleDao;
        this.accessDao = accessDao;
        this.applicationDao = applicationDao;
        this.applicationConverter = applicationConverter;
    }

    @RequestMapping("/register")
    public String getApplicationCreate(final Model model) {

        model.addAttribute("roles", roleDao.findAll());
        model.addAttribute("accesses", accessDao.findAll());
        model.addAttribute("application", new ApplicationForm());

        return "application_add";
    }

    @RequestMapping("/register/confirmation")
    public String getApplicationCreate(@ModelAttribute ApplicationForm applicationForm, Model model) {

        try {
            final Application application = applicationDao.save(applicationConverter.convert(applicationForm));
            model.addAttribute("application", application);

            model.addAttribute("title", "Udało się!");
            model.addAttribute("message", "Dziękujemy za złożenie wniosku.");
        } catch (Exception e) {
            model.addAttribute("title", "Nie udało się!");
            model.addAttribute("message", "Spróbuj jeszcze raz.");
            log.warn("Problem creating application", e);
        }

        return "application_add_confirmation";
    }
}
