package com.stella.alephart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stella.alephart.models.LocationCity;

@Repository
public interface LocationCityRepository extends JpaRepository<LocationCity, Long> {

}