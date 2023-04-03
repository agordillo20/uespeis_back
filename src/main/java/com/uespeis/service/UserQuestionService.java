package com.uespeis.service;

import java.util.List;
import com.uespeis.model.UserQuestions;

public interface UserQuestionService {
    
    public List<UserQuestions> getAnswersFromUserAndForm(Integer idUser,Integer idForm);

    public List<UserQuestions> filterUserQuestions(Integer idQuestion,Integer answer);

}