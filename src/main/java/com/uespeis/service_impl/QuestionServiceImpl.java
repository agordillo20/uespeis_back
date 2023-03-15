package com.uespeis.service_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uespeis.repository.QuestionRepository;
import com.uespeis.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    QuestionRepository repository;

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
    
}
