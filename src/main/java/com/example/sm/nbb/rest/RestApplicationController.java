package com.example.sm.nbb.rest;

import com.example.sm.nbb.converter.ApplicationConverter;
import com.example.sm.nbb.dao.ApplicationDao;
import com.example.sm.nbb.data.ApplicationForm;
import com.example.sm.nbb.entity.Application;
import com.example.sm.nbb.filter.ApplicationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/Application")
public class RestApplicationController {

    private final ApplicationDao applicationDao;
    private final ApplicationConverter applicationConverter;

    @Autowired
    public RestApplicationController(final ApplicationDao applicationDao,
                                     final ApplicationConverter applicationConverter) {
        this.applicationDao = applicationDao;
        this.applicationConverter = applicationConverter;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('SYSTEM_ADMINISTRATOR')")
    public Application get(@PathVariable final Integer id) {
        return applicationDao.findById(id).orElse(null);
    }

    @GetMapping("")
    @PreAuthorize("hasRole('SYSTEM_ADMINISTRATOR')")
    public List<Application> getAll() {
        return applicationDao.findAll();
    }

    @PostMapping("/search")
    @PreAuthorize("hasRole('SYSTEM_ADMINISTRATOR')")
    public List<Application> getAll(@RequestBody final ApplicationFilter filter) {

        // TODO: this is a very naive implementation of the method, but will do for the moment
        Predicate<Application> appliedAccessCriterion = filter.getAppliedAccessId() == null ? application -> true : application -> application.getAppliedAccess().getId().equals(filter.getAppliedAccessId());
        Predicate<Application> appliedRoleCriterion = filter.getAppliedRoleId() == null ? application -> true : application -> application.getAppliedRole().getId().equals(filter.getAppliedRoleId());
        Predicate<Application> resolvedCriterion = filter.getResolved() == null ? application -> true : application -> filter.getResolved() ? application.getResolutionDate() != null : application.getResolutionDate() == null;
        Predicate<Application> submittedAfterCriterion = filter.getSubmittedAfter() == null ? application -> true : application -> !application.getSubmissionDate().isBefore(filter.getSubmittedAfter());
        Predicate<Application> submittedBeforeCriterion = filter.getSubmittedBefore() == null ? application -> true : application -> !application.getSubmissionDate().isAfter(filter.getSubmittedBefore());

        return applicationDao.findAll().stream()
                .filter(appliedAccessCriterion)
                .filter(appliedRoleCriterion)
                .filter(resolvedCriterion)
                .filter(submittedAfterCriterion)
                .filter(submittedBeforeCriterion)
                .collect(Collectors.toList());
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('SYSTEM_ADMINISTRATOR')")
    public Application create(@RequestBody final ApplicationForm applicationForm) {
        return applicationDao.save(applicationConverter.convert(applicationForm));
    }
}
