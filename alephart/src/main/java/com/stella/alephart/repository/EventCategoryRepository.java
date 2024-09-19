package com.stella.alephart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stella.alephart.models.EventCategory;

@Repository
public interface EventCategoryRepository  extends JpaRepository<EventCategory, Long>{

}
