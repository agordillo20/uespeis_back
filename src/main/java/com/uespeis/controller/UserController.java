package com.uespeis.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.uespeis.service_impl.UserServiceImpl;
import net.minidev.json.JSONObject;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/users")
public class UserController {

    @Autowired
    private UserServiceImpl service;

    @PostMapping("/authenticate")
    public JSONObject auth(@RequestBody String msg){
        var entrada = new org.json.JSONObject(msg);
        var user = entrada.getString("user");
        var pwd = entrada.getString("password");
        var j = new JSONObject();
        j.put("resultado", service.auth(user, pwd));
        return j;
    }

    @PostMapping("/getRol")
    public JSONObject getRolFromUser(@RequestBody String user){
        var j = new JSONObject();
        j.put("resultado", service.getRol(user));
        return j;
    }
}
