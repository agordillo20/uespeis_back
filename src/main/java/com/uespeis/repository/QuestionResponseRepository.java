package com.uespeis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uespeis.model.QuestionResponse;

@Repository
public interface QuestionResponseRepository extends JpaRepository<QuestionResponse, Integer> {

    @Query("select qr from QuestionResponse qr where qr.question=?1 and (coalesce(?2) is null or (qr.answer = ?2))")
    List<QuestionResponse> filterQuestionResponse(Integer idQuestion,Integer answer);
    
    @Query("select qr from QuestionResponse qr where qr.form=?1")
    List<QuestionResponse> getAnswersFromForm(Integer idForm);
    
}
