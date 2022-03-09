package com.example.sm.nbb.rest;

import com.example.sm.nbb.dao.AccessDao;
import com.example.sm.nbb.entity.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/access")
public class RestAccessController {

    private final AccessDao dao;

    @Autowired
    public RestAccessController(final AccessDao dao) {
        this.dao = dao;
    }

    @GetMapping("/{id}")
    public Access get(@PathVariable final Integer id) {
        return dao.findById(id).orElse(null);
    }

    @GetMapping("")
    public List<Access> getAll() {
        return dao.findAll();
    }
}
