package com.uespeis.service;

import java.util.List;

import com.uespeis.model.UserQuestions;

public interface UserQuestionService {
    
    public List<UserQuestions> getAnswersFromUserAndForm(Integer id_user,Integer id_form);
}
