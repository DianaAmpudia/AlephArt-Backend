package com.stella.alephart.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stella.alephart.models.Comments;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long> {
	 

}
