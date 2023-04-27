package com.uespeis.service;

import com.uespeis.model.ActivityUserQuestionResponse;

public interface ActivityUserQuestionResponseService {
    public Integer TotalCompletedByUser(Integer idUser);
    public void save(ActivityUserQuestionResponse response);
}
