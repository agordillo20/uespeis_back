package com.uespeis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uespeis.model.ActivityUserQuestionResponse;

@Repository
public interface ActivityUserQuestionResponseRepository extends JpaRepository<ActivityUserQuestionResponse,Integer>{
    
}
