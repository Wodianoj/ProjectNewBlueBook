package com.example.sm.nbb.dao;

import com.example.sm.nbb.entity.Interpretation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterpretationDao extends JpaRepository<Interpretation, Integer> {
}
