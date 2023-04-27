package com.uespeis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uespeis.model.ActivityUserRealizated;

@Repository
public interface ActivityUserRealizatedRepository extends JpaRepository<ActivityUserRealizated,Integer>{

    @Query("Select aur from ActivityUserRealizated aur where user.id=?1 order by user.id desc")
    public List<ActivityUserRealizated> findByUserId(Integer userId);
    
}
