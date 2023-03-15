package com.uespeis.controller;

import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uespeis.model.Questions;
import com.uespeis.service.FormParentService;
import com.uespeis.service_impl.FormParentServiceImpl;
import com.uespeis.service_impl.FormServiceImpl;
import com.uespeis.service_impl.UserServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/mixed")
public class MixedController {
    
    @Autowired
    private FormParentServiceImpl serviceFormParent;
    @Autowired
    private FormServiceImpl serviceForm;
    @Autowired
    private UserServiceImpl serviceUser;

    
    @PostMapping("/getActiveQuestionsFromUser")
    public List<Questions> getActiveQuestionsFromUser(@RequestBody String mensaje){
        var entrada = new JSONArray(mensaje);
        Integer idUser = serviceUser.findUserByEmail(entrada.getString(0)).getId();
        Integer idParent = serviceForm.getActiveFormByUserId(idUser).getParent().getId();
        return  serviceFormParent.getQuestionFromParentId(idParent);
    }

}
