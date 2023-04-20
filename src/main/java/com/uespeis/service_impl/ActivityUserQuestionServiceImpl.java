package com.uespeis.service_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uespeis.repository.ActivityUserQuestionRepository;
import com.uespeis.service.ActivityUserQuestionService;

@Service
public class ActivityUserQuestionServiceImpl implements ActivityUserQuestionService {
    
    @Autowired
    private ActivityUserQuestionRepository repository;
    
}
