package com.example.sm.nbb.rest;

import com.example.sm.nbb.dao.RoleDao;
import com.example.sm.nbb.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/role")
public class RestRoleController {

    private final RoleDao dao;

    @Autowired
    public RestRoleController(final RoleDao dao) {
        this.dao = dao;
    }

    @GetMapping("/{id}")
    public Role get(@PathVariable final Integer id) {
        return dao.findById(id).orElse(null);
    }

    @GetMapping("")
    public List<Role> getAll() {
        return dao.findAll();
    }
}
