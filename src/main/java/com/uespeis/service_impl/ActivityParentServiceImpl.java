package com.uespeis.service_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uespeis.repository.ActivityParentRepository;
import com.uespeis.service.ActivityParentService;

@Service
public class ActivityParentServiceImpl implements ActivityParentService{

    @Autowired
    private ActivityParentRepository repository;
    
}
