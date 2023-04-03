package com.uespeis.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
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
        String jwt = service.auth(user, pwd);
        j.put("resultado", jwt != null);
        j.put("jwt", jwt);
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

    @PostMapping("/checkJWT")
    public boolean isJWTvalid(@RequestBody String jwt) {
        boolean result = false;
        DecodedJWT decode = JWT.decode(jwt);
        Integer idUser = Integer.parseInt(decode.getSubject());
        Optional<User> user = service.getUserById(idUser);
        if (user.isPresent()) {
            boolean condicion1 = new Date().getTime() < decode.getExpiresAt().getTime();
            boolean condicion2 = decode.getClaim("role").asString().equals(user.get().getRol());
            result = condicion1 && condicion2;
        }
        return result;
    }

    @PostMapping("/checkJWT_android")
    public JSONObject isJWTvalidAndroid(@RequestBody String msg) {
        String result = "";
        var entrada = new org.json.JSONObject(msg);
        String jwt = entrada.getString("jwt");
        DecodedJWT decode = JWT.decode(jwt);
        Integer idUser = Integer.parseInt(decode.getSubject());
        Optional<User> user = service.getUserById(idUser);
        if (user.isPresent()) {
            boolean condicion1 = new Date().getTime() < decode.getExpiresAt().getTime();
            boolean condicion2 = decode.getClaim("role").asString().equals(user.get().getRol());
            if (condicion1 && condicion2) {
                result = user.get().getEmail();
            }
        }
        var json = new JSONObject();
        json.put("resultado", result);
        return json;
    }

    @PostMapping("/profile-is-completed")
    public JSONObject checkIfProfileIsCompleted(@RequestBody String msg) {
        JSONObject result = new JSONObject();
        boolean resultb = false;
        var entrada = new org.json.JSONObject(msg);
        User u = service.findUserByEmail(entrada.getString("email"));
        if (u.getProfile() != null) {
            resultb = true;
        }
        result.put("userId", u.getId());
        result.put("resultado", resultb);
        return result;
    }

}
