package com.example.sm.nbb.dao;

import com.example.sm.nbb.entity.Classification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificationDao extends JpaRepository<Classification, Integer> {
}
