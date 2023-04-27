package com.uespeis.service;

import java.util.List;
import com.uespeis.model.ActivityParent;

public interface ActivityParentService {
    public List<ActivityParent> getAll();
    public ActivityParent findById(Integer id);
}
