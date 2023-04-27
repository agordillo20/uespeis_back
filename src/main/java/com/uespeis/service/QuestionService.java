package com.uespeis.service;

import java.util.List;
import com.uespeis.model.Question;

public interface QuestionService {

    void delete(Integer id);
    List<Question> getAll();
}
