package com.stella.alephart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stella.alephart.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
 
}

