package com.uespeis.service_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uespeis.model.Activity;
import com.uespeis.repository.ActivityRepository;
import com.uespeis.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService{
    
    @Autowired
    private ActivityRepository repository;

    @Override
    public Activity findById(Integer id) {
        return repository.getReferenceById(id);
    }
    
}
