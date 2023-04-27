package com.uespeis.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.uespeis.model.Form;
import com.uespeis.model.Profile;
import com.uespeis.model.User;
import com.uespeis.service_impl.FormServiceImpl;
import com.uespeis.service_impl.UserServiceImpl;
import com.uespeis.utils.Codifiquer;
import com.uespeis.utils.EnumTypeForUse;
import com.uespeis.utils.RequestReader;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserServiceImpl service;
    @Autowired
    private FormServiceImpl serviceForm;

    @PostMapping("/authenticate")
    public ResponseEntity<Map<String,Object>> auth(@RequestBody String msg) {
        var response = new HashMap<String,Object>();
        Map<String, String> transformToMap = RequestReader.transformToMap(msg);
        var user = transformToMap.get("user");
        var pwd = transformToMap.get("password");
        String jwt = service.auth(user, pwd);
        response.put("resultado", jwt!= null);
        response.put("jwt", jwt);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping(value = "/getRol")//revisar
    public ResponseEntity<String> getRolFromUser(@RequestBody String user) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getRol(user));
    }

    @PostMapping("/register")
    public ResponseEntity<Integer> register(@RequestBody String msg) {
        Map<String, String> transformToMap = RequestReader.transformToMap(msg);
        var email = transformToMap.get("email");
        var pwd = transformToMap.get("password");
        User u = User.builder().email(email).locked(false).rol(EnumTypeForUse.rol.DEFAULT.name()).password(Codifiquer.encode(pwd)).build();
        u = service.saveUser(u);
        serviceForm.save(Form.builder().user(u).loocked(false).build());
        return ResponseEntity.ok().body(u.getId());
    }

    @PostMapping("/checkJWT")//revisar
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
    public ResponseEntity<String> isJWTvalidAndroid(@RequestBody String msg) {
        String response = "";
        String jwt = RequestReader.transformToMap(msg).get("jwt");
        DecodedJWT decode = JWT.decode(jwt);
        Integer idUser = Integer.parseInt(decode.getSubject());
        Optional<User> user = service.getUserById(idUser);
        if (user.isPresent()) {
            boolean condicion1 = new Date().getTime() < decode.getExpiresAt().getTime();
            boolean condicion2 = decode.getClaim("role").asString().equals(user.get().getRol());
            if (condicion1 && condicion2) {
                response = user.get().getEmail();
            }
        }
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/profile-is-completed")
    public ResponseEntity<Map<String,Object>> checkIfProfileIsCompleted(@RequestBody String msg) {
        var response = new HashMap<String,Object>();
        boolean resultb = false;
        User u = service.findUserByEmail(RequestReader.transformToMap(msg).get("email"));
        if (u.getProfile() != null) {
            resultb = true;
        }
        response.put("userId", u.getId());
        response.put("resultado", resultb);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/loadProfile")
    public ResponseEntity<Profile> loadProfileFromUserId(@RequestBody String msg) {
        Optional<User> u = service.getUserById(Integer.valueOf(RequestReader.transformToMap(msg).get("userID")));
        if (u.isPresent() && u.get().getProfile()!=null) {
            return ResponseEntity.ok().body(u.get().getProfile());
        }else{
            return ResponseEntity.ok().body(new Profile());
        }
    }

}
