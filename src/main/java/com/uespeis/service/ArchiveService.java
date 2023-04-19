package com.uespeis.service;

import java.util.List;

import com.uespeis.model.Activity;

public interface ArchiveService {

    public Activity save(Activity a);
    public List<Activity> getAll();

}
