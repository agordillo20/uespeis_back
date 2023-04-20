package com.uespeis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uespeis.model.ActivityParent;

@Repository
public interface ActivityParentRepository extends JpaRepository<ActivityParent,Integer>{
    
}
