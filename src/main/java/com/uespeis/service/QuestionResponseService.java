package com.uespeis.service;

import java.util.List;
import com.uespeis.model.QuestionResponse;

public interface QuestionResponseService {
    
    public List<QuestionResponse> getAnswersFromForm(Integer idForm);
    public void save(QuestionResponse response);
    public List<QuestionResponse> filterQuestionResponse(Integer idQuestion,Integer answer);

}