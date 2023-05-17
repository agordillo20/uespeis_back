package com.uespeis.service;

import java.util.List;

import com.uespeis.model.SubActivity;

public interface SubActivityService {

    SubActivity findById(Integer id);
    void save(SubActivity subActivity);
    List<SubActivity> getAllSubActivitiesFromActivityParent(Integer id);
    
}
