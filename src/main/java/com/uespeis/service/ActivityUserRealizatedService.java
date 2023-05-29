package com.uespeis.service;

import java.util.List;
import com.uespeis.model.ActivityUserRealizated;

public interface ActivityUserRealizatedService {
    public List<ActivityUserRealizated> findByUserId(Integer userId);
    public Integer findByUserIdAndParent(Integer userId,Integer parent);
    public void save(ActivityUserRealizated done);
    
}
