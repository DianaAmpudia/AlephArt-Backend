package com.stella.alephart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stella.alephart.models.EventMode;

@Repository
public interface EventModeRepository extends JpaRepository<EventMode, Long> {

}