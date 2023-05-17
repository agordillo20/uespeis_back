package com.uespeis.service;

import java.util.List;

import com.uespeis.model.ActivityUserQuestionResponse;

public interface ActivityUserQuestionResponseService {
    public Integer TotalCompletedByUser(Integer idUser);
    public void save(ActivityUserQuestionResponse response);
    public List<ActivityUserQuestionResponse> getFromParentAndUser(int parent,int user);
}
