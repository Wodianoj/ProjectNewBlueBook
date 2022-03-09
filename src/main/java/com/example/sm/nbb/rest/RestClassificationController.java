package com.example.sm.nbb.rest;

import com.example.sm.nbb.dao.ClassificationDao;
import com.example.sm.nbb.entity.Classification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/classification")
public class RestClassificationController {

    private final ClassificationDao dao;

    @Autowired
    public RestClassificationController(ClassificationDao dao) {
        this.dao = dao;
    }

    @GetMapping("/{id}")
    public Classification get(@PathVariable final Integer id) {
        return dao.findById(id).orElse(null);
    }

    @GetMapping("")
    public List<Classification> getAll() {
        return dao.findAll();
    }
}
