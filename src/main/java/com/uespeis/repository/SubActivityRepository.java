package com.uespeis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uespeis.model.SubActivity;

@Repository
public interface SubActivityRepository extends JpaRepository<SubActivity,Integer>{

    @Query("Select sa from SubActivity sa where sa.parent.parent.id=?1")
    List<SubActivity> getAllSubActivitiesFromActivityParent(Integer id);
    
}
