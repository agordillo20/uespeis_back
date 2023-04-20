package com.uespeis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uespeis.model.ActivityUserQuestion;

@Repository
public interface ActivityUserQuestionRepository extends JpaRepository<ActivityUserQuestion,Integer>{
    
}
