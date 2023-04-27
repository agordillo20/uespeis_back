package com.uespeis.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uespeis.model.Question;
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

    @PostMapping("/getAll")
    public List<Question> getAll(){
        return service.getAll();
    }

}
