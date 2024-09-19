package com.stella.alephart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stella.alephart.models.Events;

@Repository
public interface EventsRepository extends JpaRepository<Events, Long>{

}
