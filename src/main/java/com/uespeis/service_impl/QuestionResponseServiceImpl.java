package com.uespeis.service_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uespeis.model.QuestionResponse;
import com.uespeis.repository.QuestionResponseRepository;
import com.uespeis.service.QuestionResponseService;

@Service
public class QuestionResponseServiceImpl implements QuestionResponseService{

    @Autowired
    private QuestionResponseRepository repository;

    @Override
    public List<QuestionResponse> getAnswersFromForm(Integer idForm) {
        return repository.getAnswersFromForm(idForm);
    }

    @Override
    public List<QuestionResponse> filterQuestionResponse(Integer idQuestion, Integer answer) {
        return  repository.filterQuestionResponse(idQuestion, answer);
    }

    @Override
    public void save(QuestionResponse response) {
        repository.save(response);
    }

    

    
    
}
