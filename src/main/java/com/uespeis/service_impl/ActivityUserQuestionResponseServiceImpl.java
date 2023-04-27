package com.uespeis.service_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uespeis.model.ActivityUserQuestionResponse;
import com.uespeis.repository.ActivityUserQuestionResponseRepository;
import com.uespeis.service.ActivityUserQuestionResponseService;

@Service
public class ActivityUserQuestionResponseServiceImpl implements ActivityUserQuestionResponseService{

    @Autowired
    private ActivityUserQuestionResponseRepository repository;

    @Override
    public Integer TotalCompletedByUser(Integer idUser) {
        return repository.TotalCompletedByUser(idUser);
    }

    @Override
    public void save(ActivityUserQuestionResponse response) {
        repository.save(response);
    }

    
    
}
