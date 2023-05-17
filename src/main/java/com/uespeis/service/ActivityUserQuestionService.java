package com.uespeis.service;

import java.util.List;

import com.uespeis.model.ActivityUserQuestion;

public interface ActivityUserQuestionService {
    List<ActivityUserQuestion> getAll();

    ActivityUserQuestion findById(int int1);

    void save(ActivityUserQuestion aQuestion);
}
