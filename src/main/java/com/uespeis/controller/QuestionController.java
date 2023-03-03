package com.uespeis.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.uespeis.model.Questions;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;


@RestController
@CrossOrigin("*")
@RequestMapping(path="/questions")
public class QuestionController {

    @PostMapping("/getAll")
    public JSONObject getAllQuestionsToUser(@RequestBody String mensaje){
        var entrada = new org.json.JSONObject(mensaje);
        var user = entrada.getString("user");

        return null;

    }
    
}
