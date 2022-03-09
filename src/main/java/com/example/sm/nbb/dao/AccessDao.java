package com.example.sm.nbb.dao;

import com.example.sm.nbb.entity.Access;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessDao extends JpaRepository<Access, Integer> {
}
