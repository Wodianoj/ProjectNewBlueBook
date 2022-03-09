package com.example.sm.nbb.controller;

import com.example.sm.nbb.dao.AccessDao;
import com.example.sm.nbb.dao.ApplicationDao;
import com.example.sm.nbb.dao.RoleDao;
import com.example.sm.nbb.entity.Application;
import com.example.sm.nbb.filter.ApplicationFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Controller
@Slf4j
public class ApplicationController {

    private final ApplicationDao dao;
    private final RoleDao roleDao;
    private final AccessDao accessDao;

    @Autowired
    public ApplicationController(final ApplicationDao dao, final RoleDao roleDao, final AccessDao accessDao) {
        this.dao = dao;
        this.roleDao = roleDao;
        this.accessDao = accessDao;
    }

    @RequestMapping("/application/list")
    @PreAuthorize("hasRole('SYSTEM_ADMIN')")
    public String getApplicationView(@ModelAttribute ApplicationFilter filter, final Model model) {

        model.addAttribute("roles", roleDao.findAll());
        model.addAttribute("accesses", accessDao.findAll());

        if (filter == null) {
            filter = new ApplicationFilter();
            model.addAttribute("filter", filter);
            model.addAttribute("applications", dao.findAll());
        } else {
            model.addAttribute("filter", filter);
            model.addAttribute("applications", search(filter));
        }

        return "application_view";
    }

    @RequestMapping("/application/search")
    @PreAuthorize("hasRole('SYSTEM_ADMIN')")
    public String getApplicationSearch(@ModelAttribute ApplicationFilter filter, final Model model) {

        if (filter == null) {
            filter = new ApplicationFilter();
            model.addAttribute("filter", filter);
            model.addAttribute("applications", dao.findAll());
        } else {
            model.addAttribute("applications", search(filter));
        }
        return "application_search";
    }

    private List<Application> search(final ApplicationFilter filter) {
        // TODO: this is a very naive implementation of the method, but will do for the moment
        Predicate<Application> appliedAccessCriterion = filter.getAppliedAccessId() == null ? application -> true : application -> application.getAppliedAccess().getId().equals(filter.getAppliedAccessId());
        Predicate<Application> appliedRoleCriterion = filter.getAppliedRoleId() == null ? application -> true : application -> application.getAppliedRole().getId().equals(filter.getAppliedRoleId());
        Predicate<Application> resolvedCriterion = filter.getResolved() == null ? application -> true : application -> filter.getResolved() ? application.getResolutionDate() != null : application.getResolutionDate() == null;
        Predicate<Application> submittedAfterCriterion = filter.getSubmittedAfter() == null ? application -> true : application -> !application.getSubmissionDate().isBefore(filter.getSubmittedAfter());
        Predicate<Application> submittedBeforeCriterion = filter.getSubmittedBefore() == null ? application -> true : application -> !application.getSubmissionDate().isAfter(filter.getSubmittedBefore());

        return dao.findAll().stream()
                .filter(appliedAccessCriterion)
                .filter(appliedRoleCriterion)
                .filter(resolvedCriterion)
                .filter(submittedAfterCriterion)
                .filter(submittedBeforeCriterion)
                .collect(Collectors.toList());
    }
}
