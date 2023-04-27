package com.uespeis.service_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uespeis.model.ActivityUserQuestion;
import com.uespeis.repository.ActivityUserQuestionRepository;
import com.uespeis.service.ActivityUserQuestionService;

@Service
public class ActivityUserQuestionServiceImpl implements ActivityUserQuestionService {
    
    @Autowired
    private ActivityUserQuestionRepository repository;

    @Override
    public List<ActivityUserQuestion> getAll() {
        return repository.findAll();
    }

    @Override
    public ActivityUserQuestion findById(int int1) {
        return repository.getReferenceById(int1);
    }
    
}
