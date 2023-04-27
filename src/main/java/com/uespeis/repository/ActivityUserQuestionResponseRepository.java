package com.uespeis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uespeis.model.ActivityUserQuestionResponse;

@Repository
public interface ActivityUserQuestionResponseRepository extends JpaRepository<ActivityUserQuestionResponse,Integer>{
    
    @Query("SELECT count(a) FROM ActivityUserQuestion a,ActivityUserQuestionResponse b WHERE b.user.id=?1 and a.id=b.activityUserQuestion.id")
    Integer TotalCompletedByUser(Integer idUser);


}
