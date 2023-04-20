package com.uespeis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uespeis.model.ActivityUserRealizated;

@Repository
public interface ActivityUserRealizatedRepository extends JpaRepository<ActivityUserRealizated,Integer>{
    
}
