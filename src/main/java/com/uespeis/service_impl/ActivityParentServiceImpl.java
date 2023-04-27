package com.uespeis.service_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uespeis.model.ActivityParent;
import com.uespeis.repository.ActivityParentRepository;
import com.uespeis.service.ActivityParentService;

@Service
public class ActivityParentServiceImpl implements ActivityParentService{

    @Autowired
    private ActivityParentRepository repository;

    @Override
    public List<ActivityParent> getAll() {
        return repository.findAll();
    }

    @Override
    public ActivityParent findById(Integer id) {
        return repository.getReferenceById(id);
    }
    
    
}
