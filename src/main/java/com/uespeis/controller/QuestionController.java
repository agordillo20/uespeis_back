package com.uespeis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.uespeis.service_impl.QuestionServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/questions")
public class QuestionController {

    @Autowired
    QuestionServiceImpl service;

    @DeleteMapping("/delete/{id}")
    public void deleteQuestion(@PathVariable("id") Integer id){
        service.delete(id);
    }

}
