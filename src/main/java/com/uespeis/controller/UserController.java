package com.uespeis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.uespeis.model.User;
import com.uespeis.service_impl.UserServiceImpl;
import com.uespeis.utils.EnumTypeForUse;

import net.minidev.json.JSONObject;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/users")
public class UserController {

    @Autowired
    private UserServiceImpl service;

    @GetMapping("/test1")
    public String test() {
        service.saveUser(
                new User(EnumTypeForUse.gender.MALE, EnumTypeForUse.civil_status.MARRIED, EnumTypeForUse.rol.DEFAULT));
        return "llega";
    }

    @PostMapping("/authenticate")
    public JSONObject auth(@RequestBody String msg){
        var entrada = new org.json.JSONObject(msg);
        var user = entrada.getString("user");
        var pwd = entrada.getString("password");
        var j = new JSONObject();
        j.put("resultado", service.auth(user, pwd));
        return j;
    }
}
