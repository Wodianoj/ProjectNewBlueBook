package com.example.sm.nbb.rest;

import com.example.sm.nbb.dao.UserDao;
import com.example.sm.nbb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class RestUserController {

    private final UserDao userDao;

    @Autowired
    public RestUserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/{id}")
    public User get(@PathVariable final Integer id) {
        return userDao.findById(id).orElse(null);
    }
}
