package com.uespeis.service;

import java.util.List;

import com.uespeis.model.Activity;

public interface ActivityService {
    public Activity findById(Integer id);
    public List<Activity> getAll();
    public void save(Activity activity);
    
}
