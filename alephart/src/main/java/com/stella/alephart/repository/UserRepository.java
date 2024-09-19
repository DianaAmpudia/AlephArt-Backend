package com.stella.alephart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stella.alephart.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	
}
