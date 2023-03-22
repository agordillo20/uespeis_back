package com.uespeis.service;

import java.util.List;

import com.uespeis.model.FormParent;
import com.uespeis.model.Questions;

public interface FormParentService {

     public FormParent save(FormParent parent);

     public List<FormParent> getAll();

     public List<Questions> getQuestionFromParentId(Integer id);
     
}
