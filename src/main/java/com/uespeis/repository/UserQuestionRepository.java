package com.uespeis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uespeis.model.UserQuestions;

@Repository
public interface UserQuestionRepository extends JpaRepository<UserQuestions, Integer> {

    @Query("select uq from UserQuestions uq where uq.idQuestion=?1 and (coalesce(?2) is null or (uq.answer = ?2))")
    List<UserQuestions> filterUserQuestions(Integer idQuestion,Integer answer);
    
    
}
