package com.example.sm.nbb.dao;

import com.example.sm.nbb.entity.Observer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObserverDao extends JpaRepository<Observer, Integer> {
}
