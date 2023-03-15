package com.uespeis.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.uespeis.model.Form;
import com.uespeis.service_impl.FormServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/forms")
public class FormController {

    @Autowired
    private FormServiceImpl service;

    @PostMapping("/getAllFormsByUserId/{id}")
    public List<Form> getAll(@PathVariable("id") Integer id){
        return service.getAllFormsByUserId(id);
    }

    @PostMapping("/getActiveFormByUserId/{id}")
    public Form getActiveFormByUserId(@PathVariable("id") Integer id){
        return service.getActiveFormByUserId(id);
    }

}
