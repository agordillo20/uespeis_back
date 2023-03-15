package com.uespeis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uespeis.model.UserQuestions;

@Repository
public interface UserQuestionRepository extends JpaRepository<UserQuestions, Integer> {

    
    
}
