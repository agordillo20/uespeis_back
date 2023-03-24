package com.uespeis.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uespeis.model.Form;
import com.uespeis.model.User;
import com.uespeis.service_impl.FormParentServiceImpl;
import com.uespeis.service_impl.FormServiceImpl;
import com.uespeis.service_impl.UserServiceImpl;
import com.uespeis.utils.Codifiquer;
import com.uespeis.utils.EnumTypeForUse;

import net.minidev.json.JSONObject;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserServiceImpl service;
    @Autowired
    private FormServiceImpl serviceForm;
    @Autowired
    private FormParentServiceImpl serviceFormParent;

    @PostMapping("/authenticate")
    public JSONObject auth(@RequestBody String msg) {
        var entrada = new org.json.JSONObject(msg);
        var user = entrada.getString("user");
        var pwd = entrada.getString("password");
        var j = new JSONObject();
        j.put("resultado", service.auth(user, pwd));
        return j;
    }

    @PostMapping("/getRol")
    public JSONObject getRolFromUser(@RequestBody String user) {
        var j = new JSONObject();
        j.put("resultado", service.getRol(user));
        return j;
    }

    @PostMapping("/register")
    public JSONObject register(@RequestBody String msg) {
        var entrada = new org.json.JSONObject(msg);
        var email = entrada.getString("email");
        var pwd = entrada.getString("password");
        User u = new User(EnumTypeForUse.rol.DEFAULT);
        u.setEmail(email);
        u.setLocked(false);
        u.setPassword(Codifiquer.encode(pwd));
        User userRegister = service.saveUser(u);
        serviceFormParent.getAll().forEach(p -> {
            Form f = new Form();
            f.setIdUser(userRegister.getId());
            System.out.println(p.getType());
            f.setLoocked(!p.getType().equals("primary"));
            f.setParent(p);
            serviceForm.save(f);
        });
        var j = new JSONObject();
        j.put("resultado", userRegister.getId());
        return j;
    }

    

}
