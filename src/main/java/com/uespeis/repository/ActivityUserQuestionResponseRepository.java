package com.uespeis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uespeis.model.ActivityUserQuestionResponse;

@Repository
public interface ActivityUserQuestionResponseRepository extends JpaRepository<ActivityUserQuestionResponse,Integer>{
    
    @Query("SELECT count(a) FROM ActivityUserQuestion a,ActivityUserQuestionResponse b WHERE b.user.id=?1 and a.id=b.activityUserQuestion.id")
    Integer TotalCompletedByUser(Integer idUser);

    @Query("SELECT a FROM ActivityUserQuestionResponse a WHERE a.user.id=?2 and a.activityUserQuestion.parent.parent.id=?1")
    List<ActivityUserQuestionResponse> getFromParentAndUser(int parent, int user);


}
