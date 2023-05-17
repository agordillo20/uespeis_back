package com.uespeis.service_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uespeis.model.SubActivity;
import com.uespeis.repository.SubActivityRepository;
import com.uespeis.service.SubActivityService;

@Service
public class SubActivityServiceImpl implements SubActivityService{

    @Autowired
    private SubActivityRepository repository;
    
    @Override
    public SubActivity findById(Integer id) {
        return repository.getReferenceById(id);
    }

    @Override
    public void save(SubActivity subActivity) {
        repository.save(subActivity);
    }

    @Override
    public List<SubActivity> getAllSubActivitiesFromActivityParent(Integer id) {
       return repository.getAllSubActivitiesFromActivityParent(id);
    }
    
}
