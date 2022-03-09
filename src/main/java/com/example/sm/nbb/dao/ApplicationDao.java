package com.example.sm.nbb.dao;

import com.example.sm.nbb.entity.Application;
import com.example.sm.nbb.filter.ApplicationFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationDao extends JpaRepository<Application, Integer> {

    boolean existsByEmail(final String email);
}
