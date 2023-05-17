package com.uespeis.service;

import com.uespeis.model.Activity;

public interface ActivityService {
    public Activity findById(Integer id);

    public void save(Activity activity);
    
}
