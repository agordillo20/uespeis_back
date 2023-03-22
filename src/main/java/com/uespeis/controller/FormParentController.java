package com.uespeis.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uespeis.model.FormParent;
import com.uespeis.service_impl.FormParentServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/formsParent")
public class FormParentController {

    @Autowired
    private FormParentServiceImpl service;

    @PostMapping("/getAll")
    public List<FormParent> getAll(){
        return service.getAll();
    }

    @PostMapping("/update")
    public FormParent update(@RequestBody String mensaje){
        var entrada = new org.json.JSONObject(mensaje);
        ObjectMapper mapper = new ObjectMapper();
        try {
            FormParent formu = mapper.readValue(entrada.toString(), new TypeReference<FormParent>() {});
            formu.getQuestions().forEach(q->q.setFormId(formu));
            return service.save(formu);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
