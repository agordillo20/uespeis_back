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
    public boolean register(@RequestBody String msg) {
        var entrada = new org.json.JSONObject(msg);
        boolean result = false;
        ObjectMapper mapper = new ObjectMapper();
        try {
            User userr = mapper.readValue(entrada.toString(), new TypeReference<User>() {});
            User u = service.saveUser(userr);
            if (u != null) {
                serviceFormParent.getAll().forEach(p -> {
                    Form f = new Form();
                    f.setIdUser(u.getId());
                    f.setLoocked(!p.getType().equals("primary"));
                    f.setParent(p);
                    serviceForm.save(f);
                });
                result = true;
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
