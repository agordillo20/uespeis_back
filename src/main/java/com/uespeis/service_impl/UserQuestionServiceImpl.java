package com.uespeis.service_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uespeis.model.UserQuestions;
import com.uespeis.repository.UserQuestionRepository;
import com.uespeis.service.UserQuestionService;

@Service
public class UserQuestionServiceImpl implements UserQuestionService{

    @Autowired
    private UserQuestionRepository repository;

    @Override
    public List<UserQuestions> getAnswersFromUserAndForm(Integer idUser, Integer idForm) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAnswersFromUserAndForm'");
    }

    @Override
    public List<UserQuestions> filterUserQuestions(Integer idQuestion, Integer answer) {
        return  repository.filterUserQuestions(idQuestion, answer);
    }

    
    
}
