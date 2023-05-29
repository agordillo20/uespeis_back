package com.uespeis.service_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uespeis.model.ActivityUserRealizated;
import com.uespeis.repository.ActivityUserRealizatedRepository;
import com.uespeis.service.ActivityUserRealizatedService;
@Service
public class ActivityUserRealizatedServiceImpl implements ActivityUserRealizatedService{

    @Autowired
    private ActivityUserRealizatedRepository repository;

    @Override
    public List<ActivityUserRealizated> findByUserId(Integer userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public void save(ActivityUserRealizated done) {
        repository.save(done);
    }

    @Override
    public Integer findByUserIdAndParent(Integer userId, Integer parent) {
        return repository.findByUserIdAndParent(userId, parent);
    }
    
}
