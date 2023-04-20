package com.uespeis.service_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uespeis.repository.ActivityUserRealizatedRepository;
import com.uespeis.service.ActivityUserRealizatedService;
@Service
public class ActivityUserRealizatedServiceImpl implements ActivityUserRealizatedService{

    @Autowired
    private ActivityUserRealizatedRepository repository;
    
}
