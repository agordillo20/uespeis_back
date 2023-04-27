package com.uespeis.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uespeis.model.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Integer> {

        
    
}
