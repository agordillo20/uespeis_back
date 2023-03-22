package com.uespeis.service_impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uespeis.model.FormParent;
import com.uespeis.model.Questions;
import com.uespeis.repository.FormParentRepository;
import com.uespeis.service.FormParentService;

@Service
public class FormParentServiceImpl implements FormParentService{

    @Autowired
    FormParentRepository repository;

    @Override
    public FormParent save(FormParent parent) {
        return repository.save(parent);
    }

    @Override
    public List<FormParent> getAll(){
        return repository.findAll();
    }

    @Override
    public List<Questions> getQuestionFromParentId(Integer id){
        FormParent parent = repository.getReferenceById(id);
        return parent.getQuestions();
    }

    
    
}
